package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Crank extends BicyclePart {

    //usually 96 or 104
    private Integer pcdBig;

    //i.e. 96, 104. Distance in mm from one hole in arm to hole in opposite arm
    private Integer pcdSmall;

    //4 - MTB, 5 - Road. Arms can be symmetric or asymmetric. Type without arms - DIRECT MOUNT
    private String armsAndType;

    //165, 170, 172.5, 175
    private String armLength;

    private String cartridgeType;

    //1, 2, 3
    private Integer numberOfGears;
    private Integer speeds;
    private Integer qFactor;
    private Double chainLine;

    //only in integrated systems
    private Double axleDiameter;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring bigGear;

    private String bigGearModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring mediumGear;

    private String mediumGearModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring smallGear;

    private String smallGearModel;

}
