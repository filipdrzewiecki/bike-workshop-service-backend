package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart {


    protected Double headTubeLength;
    protected Double headTubeTopDiameter;
    protected Double headTubeBottomDiameter;
    private String year;

    private String forkTubeType;

    protected String axleSize;
    private String material;
    protected String wheel;
    protected String brakeType;
    protected String discMount;

    private String offset;

    //suspensionFork
    private Double travel;
    private String leftChamber;
    private String rightChamber;
    private String uppersSize;
    private String remoteLockout;
    private String adjustments;
    private String suspensionType;
}
