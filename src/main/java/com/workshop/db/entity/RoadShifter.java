package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RoadShifter extends BicyclePart {

    private Integer shifts;
    private Integer side;

    //Cable, Hydraulic
    private String brakeType;

}
