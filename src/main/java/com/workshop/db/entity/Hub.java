package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Hub extends BicyclePart{


    private Integer holes;
    private String axleDiameter;
    private String axleType;
    private String discType;
    private Double offsetLeft;
    private Double offsetRight;
    private Double pcdLeft;
    private Double pcdRight;
    private String hubType;

    private Integer speeds;
    private Double freewheelWidth;
    private String freewheelType;

}
