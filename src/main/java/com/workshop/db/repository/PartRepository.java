package com.workshop.db.repository;

import com.workshop.db.specification.PartQueryBuilder;
import com.workshop.db.specification.PartSpec;
import com.workshop.db.specification.PartSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    private List<String> partTables;

    public Page<BicyclePart> findAll(PartSpecification spec, Pageable pageable) {
        String sql = new PartQueryBuilder().all(getAllTables()).paged().build();
        String total = new PartQueryBuilder().all(getAllTables()).total().build();
        return findParts(BicyclePart.class, sql, total, spec, pageable);
    }

    public <T> Page<T> findAllOfType(PartSpec type, Pageable pageable, PartSpecification spec) {
        String sql = new PartQueryBuilder().all(List.of(type.getTable())).paged().build();
        String total = new PartQueryBuilder().all(List.of(type.getTable())).total().build();
        return findParts(type.getClazz(), sql, total, spec, pageable);
    }

    public <T> Page<T> findParts(Class<T> clazz, String sql, String totalSql, PartSpecification spec, Pageable pageable) {
        Map<String, Object> params = assembleParams(spec, pageable);
        List<T> parts = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(clazz));
        Integer total = jdbcTemplate.queryForObject(totalSql, params, Integer.class);
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

    private List<String> getAllTables() {
        if (partTables == null) {
            partTables = PART_SPEC_MAP.values().stream().map(PartSpec::getTable).collect(Collectors.toList());
        }
        return partTables;
    }
}
