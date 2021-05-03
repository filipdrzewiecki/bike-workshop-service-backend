package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BrakeRotor extends BicyclePart {

    private Integer diameter;
    private String padType;

}
