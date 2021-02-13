package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Stem extends BicyclePart {


    private Integer length;
    private Integer angle;
    private Double headtubeDiameter;
    private Double handlebarDiameter;

}
