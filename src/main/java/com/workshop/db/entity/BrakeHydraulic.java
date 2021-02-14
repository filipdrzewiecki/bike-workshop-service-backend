package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeHydraulic extends BicyclePart {

    @OneToOne
    @JoinColumn(name = "lever_id")
    private BrakeLever brakeLever;

    @OneToOne
    @JoinColumn(name = "caliper_id")
    private BrakeCaliper brakeCaliper;

    //Mineral, DOT
    private String oilType;

    private String brakePads;

    //Front, Rear, Left, Right
    private String side;

    //SM-BH90-SBM, SM-BH90-SBLS
    private String hoseType;
}
