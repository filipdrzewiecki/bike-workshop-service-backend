package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Tyre extends BicyclePart{

    private Integer width;
    private Boolean tubeless;
    private Integer diameter;
    private String type;
    private String tpi;
}
