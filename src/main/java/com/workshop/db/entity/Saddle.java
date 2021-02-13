package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Saddle extends BicyclePart {

    private Integer length;
    private Integer width;
    private String material;

}
