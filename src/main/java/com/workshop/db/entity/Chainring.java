package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Chainring extends BicyclePart {


    //Narrow-wide or Regular
    private String type;

    //4 - MTB, 5 - Road. Arms can be symmetric or asymmetric. Type without arms - DIRECT MOUNT
    private String armsAndType;

    //i.e. 96, 104. Distance in mm from one hole in arm to hole in opposite arm
    private Integer pcd;

    private Integer teethNumber;

    private Integer speeds;
}
