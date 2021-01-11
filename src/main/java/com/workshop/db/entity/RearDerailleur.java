package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class RearDerailleur extends BicyclePart {


    private int minLowGearCassette;
    private int maxLowGearCassette;
    private int maxGears;
    private int speeds;

    //short, medium, long
    private String cage;
    private int capacity;

}
