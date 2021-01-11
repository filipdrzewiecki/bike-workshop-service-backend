package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Damper extends BicyclePart {


    private int stroke;
    private int eyeToEyeLength;
    private int bodyLength;

}
