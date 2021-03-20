package com.workshop.db.specification;

import com.workshop.enums.PartType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Experiments
public class PartQueryBuilder {

    private static final String columns = "id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment";


    private String query;

    public PartQueryBuilder() {
    }

    public PartQueryBuilder(String base) {
        this.query = base;
    }


    public PartQueryBuilder base(String base) {
        this.query = base;
        return this;
    }

    public PartQueryBuilder where(String condition) {
        this.query = query + " where " + condition;
        return this;
    }

    public PartQueryBuilder and(String condition) {
        this.query = query + " and " + condition;
        return this;
    }

    public PartQueryBuilder from(String condition) {
        this.query = query + " from " + condition;
        return this;
    }

    public PartQueryBuilder select(String condition) {
        this.query = query + " select " + condition;
        return this;
    }

    public PartQueryBuilder unionAll() {
        this.query = query + " union all ";
        return this;
    }


    public String build() {
        return this.query + ";";
    }
}
