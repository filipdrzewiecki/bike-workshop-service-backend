package com.workshop.db.specification;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

//Experiments
@NoArgsConstructor
public class PartQueryBuilder {

    private static final String COMMON_COLUMNS = "id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment";

    private static final String WHERE = " where " +
            "is_official=:isOfficial and " +
            "(:brand is null or brand = :brand) and " +
            "(:series is null or series = :series) and " +
            "(:year is null or year = :year) and " +
            "(:model is null or model = :model) and " +
            "(:userId is null or user_id = :userId) ";

    private static final String LIMIT = " limit :offset, :size ";

    private String query;

    public PartQueryBuilder all(List<String> tables) {
        List<String> selects = tables
                .stream()
                .map(partType -> String.format(" select %s \n from %s %s", COMMON_COLUMNS, partType, WHERE))
                .collect(Collectors.toList());
        if (selects.size() == 1) {
            this.query = selects.stream().findFirst().get();
        } else {
            this.query = String.join(" \n union all  \n", selects);
        }
        return this;
    }

    public PartQueryBuilder paged() {
        this.query = this.query + LIMIT;
        return this;
    }

    public PartQueryBuilder total() {
        this.query = String.format("select count(*) from ( %s ) parts", this.query);
        return this;
    }

    public String build() {
        return this.query + ";";
    }
}
