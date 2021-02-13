package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Handlebar extends BicyclePart {


    //mountain
    private Double diameter;
    private Double offsetBack;
    private Integer width;
    private Integer rise;
    //mountain

    //road
    private Integer barDrop;
    private Integer barReach;
    //road

    //Carbon, Aluminium, Steel, Magnesium, Titanium
    private String material;

    //mountain, road, trekking
    private String partType;

}
