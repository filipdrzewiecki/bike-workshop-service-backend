package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Shifter extends BicyclePart {

    private Integer shifts;
    private Integer speeds;
    private String side;

    private Boolean integratedBrake;
    private String brakeType;
}
