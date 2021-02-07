package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class RearDerailleur extends BicyclePart {

    private Integer minSprocket;
    private Integer maxSprocket;
    private Integer maxGears;
    private Integer speeds;

    //short, medium, long
    private String cage;
    private Integer capacity;

}
