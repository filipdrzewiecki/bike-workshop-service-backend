package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart {


    private Double headTubeLength;
    private Double headTubeTopDiameter;
    private Double headTubeBottomDiameter;
    private String year;

    private String forkTubeType;

    private String axleSize;
    private String axleType;
    private String material;
    private String wheel;
    private String brakeType;
    private String discMount;

    private String offset;

    //suspensionFork
    private Double travel;
    private String spring;
    private String damper;
    private String uppersSize;
    private String remoteLockout;
    private String adjustments;
    private String suspensionType;
}
