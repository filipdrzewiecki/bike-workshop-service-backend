package com.workshop.db.repository;

import com.workshop.db.entity.BicyclePart;
import com.workshop.db.specification.PartSpecification;
import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PartRepositories {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final BottomBracketRepository bottomBracketRepository;
    private final BrakeCaliperRepository brakeCaliperRepository;
    private final BrakeHydraulicRepository brakeHydraulicRepository;
    private final BrakeLeverRepository brakeLeverRepository;
    private final CassetteRepository cassetteRepository;
    private final ChainRepository chainRepository;
    private final ChainringRepository chainringRepository;
    private final CrankRepository crankRepository;
    private final DamperRepository damperRepository;
    private final DiscRepository discRepository;
    private final FrameRepository frameRepository;
    private final ForkRepository forkRepository;
    private final FrontDerailleurRepository frontDerailleurRepository;
    private final GripsRepository gripsRepository;
    private final HandlerbarRepository handlerbarRepository;
    private final HeadsetRepository headsetRepository;
    private final HubRepository hubRepository;
    private final PedalsRepository pedalsRepository;
    private final RearDerailleurRepository rearDerailleurRepository;
    private final RimRepository rimRepository;
    private final SaddleRepository saddleRepository;
    private final SeatpostClampRepository seatpostClampRepository;
    private final SeatpostRepository seatpostRepository;
    private final ShifterRepository shifterRepository;
    private final StemRepository stemRepository;
    private final TyreRepository tyreRepository;
    private final WheelRepository wheelRepository;

    public Map<Object, Object> getRepositoryInstance() {
        return Map.ofEntries(
                Map.entry(PartType.BOTTOM_BRACKET, bottomBracketRepository),
                Map.entry(PartType.BRAKE_HYDRAULIC, brakeHydraulicRepository),
                Map.entry(PartType.BRAKE_CALIPER, brakeCaliperRepository),
                Map.entry(PartType.BRAKE_LEVER, brakeLeverRepository),
                Map.entry(PartType.CASSETTE, cassetteRepository),
                Map.entry(PartType.CHAIN, chainRepository),
                Map.entry(PartType.CHAINRING, chainringRepository),
                Map.entry(PartType.CRANK, crankRepository),
                Map.entry(PartType.DAMPER, damperRepository),
                Map.entry(PartType.DISC, discRepository),
                Map.entry(PartType.FRAME, frameRepository),
                Map.entry(PartType.FORK, forkRepository),
                Map.entry(PartType.FRONT_DERAILLEUR, frontDerailleurRepository),
                Map.entry(PartType.GRIPS, gripsRepository),
                Map.entry(PartType.HANDLEBAR, handlerbarRepository),
                Map.entry(PartType.HEADSET, headsetRepository),
                Map.entry(PartType.HUB, hubRepository),
                Map.entry(PartType.PEDALS, pedalsRepository),
                Map.entry(PartType.REAR_DERAILLEUR, rearDerailleurRepository),
                Map.entry(PartType.RIM, rimRepository),
                Map.entry(PartType.SADDLE, saddleRepository),
                Map.entry(PartType.SEATPOST_CLAMP, seatpostClampRepository),
                Map.entry(PartType.SEATPOST, seatpostRepository),
                Map.entry(PartType.SHIFTER, shifterRepository),
                Map.entry(PartType.STEM, stemRepository),
                Map.entry(PartType.TYRE, tyreRepository),
                Map.entry(PartType.WHEEL, wheelRepository));
    }

    private static final String COLUMNS = "id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment";

    private static final List<String> parts = List.of(
            "bottom_bracket", "frame", "fork", "brake_caliper", "brake_lever", "brake_hydraulic", "cassette", "chain", "chainring",
            "crank", "disc", "damper", "front_derailleur", "rear_derailleur", "grips", "head_set", "handlebar", "hub", "pedals",
            "saddle", "rim", "seatpost_clamp", "seatpost", "shifter", "stem", "tyre", "wheel"
    );

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
        List<String> selects = parts
                .stream()
                .map(partType -> String.format(" select %s \n from %s %s", COLUMNS, partType, WHERE))
                .collect(Collectors.toList());

        return String.join(" \n union all  \n", selects);
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
}
