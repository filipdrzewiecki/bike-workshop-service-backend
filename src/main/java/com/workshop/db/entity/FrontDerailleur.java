package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class FrontDerailleur extends BicyclePart {


    private Integer maxBigGear;
    private Integer minBigGear;
    private Integer capacity;

    //number of gears in crank
    private Integer gears;

    //number of speeds in rear derailleur
    private Integer speeds;

    //top, down, or mid
    private String cableRouteType;

    private Integer gearMaxDifference;

    private String cage;

    private String mount;
    private Double chainLine;
    private String chainstayAngle;

}
