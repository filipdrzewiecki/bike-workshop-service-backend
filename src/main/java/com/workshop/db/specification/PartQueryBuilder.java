package com.workshop.db.specification;

//Experiments
public class PartQueryBuilder {

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

    public String build() {
        return this.query;
    }
}
