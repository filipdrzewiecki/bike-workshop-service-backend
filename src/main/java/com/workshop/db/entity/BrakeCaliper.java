package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeCaliper extends BicyclePart {

    //DISC, ROAD, V-BRAKE
    private String brakeCaliperType;

    //Front, Rear
    private String side;

    //Mineral, DOT
    private String oilType;

    private String brakePads;

    //SM-BH90-SBM, SM-BH90-SBLS
    private String hoseType;

    private String type;
}
