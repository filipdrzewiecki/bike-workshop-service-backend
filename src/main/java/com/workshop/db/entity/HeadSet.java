package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class HeadSet extends BicyclePart {


    private Double stereerDiameter;
    private Double topFrameDiameter;
    private Double bottomFrameDiameter;
    private Double topHeadTubeDiameter;
    private Double bottomHeadTubeDiameter;

    //a-head, semi-integrated, integrated
    private String type;

    //Regular, Tapered
    private String forkTubeType;

}
