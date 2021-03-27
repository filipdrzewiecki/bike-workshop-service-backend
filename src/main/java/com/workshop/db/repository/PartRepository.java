package com.workshop.db.repository;

import com.workshop.db.specification.PartSpec;
import com.workshop.db.specification.PartSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.workshop.db.entity.BicyclePart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.workshop.db.specification.PartSpecifications.PART_SPEC_MAP;

@Repository
@RequiredArgsConstructor
public class PartRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String COLUMNS = "id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment";

    private List<String> partTables;

    private static final String WHERE = " where " +
            "is_official=:isOfficial and " +
            "(:brand is null or brand = :brand) and " +
            "(:series is null or series = :series) and " +
            "(:year is null or year = :year) and " +
            "(:model is null or model = :model) and " +
            "(:userId is null or user_id = :userId) ";


    private String formQuery() {
        return formBaseQuery() + " limit :offset, :size ;";
    }

    private String formBaseQuery() {

        List<String> selects = getAllTables()
                .stream()
                .map(partType -> String.format(" select %s \n from %s %s", COLUMNS, partType, WHERE))
                .collect(Collectors.toList());

        return String.join(" \n union all  \n", selects);
    }

    public <T> Page<T> findAllPartsOfType(PartSpec type, Pageable pageable, PartSpecification spec) {
        Map<String, Object> params = assembleParams(spec, pageable);

        String sql = formTypedQuery(type.getTable());

        List<T> parts = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(type.getClazz()));

        String totalSql = formTypedTotalQuery(type.getTable());

        Integer total = jdbcTemplate.queryForObject(totalSql, assembleParams(spec), Integer.class);

        if (total == null) {
            throw new IllegalStateException("Couldn't find complete list of total parts");
        }
        return new PageImpl<>(parts, pageable, total);
    }

    private String assembleTypedPartQuery(String partName) {
        String where = WHERE;

        String queryString = String.format("select * from %s part %s", partName, where);

        return queryString;
    }

    private String formTypedQuery(String partName) {
        return assembleTypedPartQuery(partName) + " limit :offset, :size ;";
    }

    private String formTypedTotalQuery(String partName) {
        return String.format("select count(*) from ( %s ) parts;", assembleTypedPartQuery(partName));
    }


    private String formTotalQuery() {
        return String.format("select count(*) from ( %s ) parts;", formBaseQuery());
    }

    public Page<BicyclePart> findAllParts(PartSpecification spec, Pageable pageable) {

        Map<String, Object> params = assembleParams(spec, pageable);

        List<BicyclePart> parts = jdbcTemplate.query(formQuery(), params, mapParts());

        Integer total = jdbcTemplate.queryForObject(formTotalQuery(), assembleParams(spec), Integer.class);
        if (total == null) {
            throw new IllegalStateException("Couldn't find complete list of total parts");
        }
        return new PageImpl<>(parts, pageable, total);
    }

    private Map<String, Object> assembleParams(PartSpecification spec, Pageable pageable) {
        Map<String, Object> params = assembleParams(spec);
        params.put("offset", pageable.getOffset());
        params.put("size", pageable.getPageSize());
        return params;
    }

    private Map<String, Object> assembleParams(PartSpecification spec) {
        Map<String, Object> params = new HashMap<>();
        if (spec == null) {
            return params;
        }
        params.put("isOfficial", spec.isOfficial());
        params.put("brand", spec.getBrand());
        params.put("model", spec.getModel());
        params.put("series", spec.getSeries());
        params.put("year", spec.getYear());
        params.put("userId", spec.getUserId());
        return params;
    }

    private RowMapper<BicyclePart> mapParts() {
        return (row, rowNum) -> BicyclePart.builder()
                .id(row.getLong("id"))
                .brand(row.getString("brand"))
                .productId(row.getString("product_id"))
                .weight(row.getBigDecimal("weight"))
                .product(row.getString("product"))
                .isOfficial(row.getBoolean("is_official"))
                .model(row.getString("model"))
                .series(row.getString("series"))
                .purpose(row.getString("purpose"))
                .year(row.getString("year"))
                .comment(row.getString("comment"))
                .ean(row.getString("ean"))
                .manufacturersCode(row.getString("manufacturers_code"))
                .build();
    }

    private List<String> getAllTables() {
        if (partTables == null) {
            partTables = PART_SPEC_MAP.values().stream().map(PartSpec::getTable).collect(Collectors.toList());
        }
        return partTables;
    }
}
