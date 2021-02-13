package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BottomBracket extends BicyclePart {


    //Integrated, Cartridge
    private String type;

    //Threaded(BSA), Press-fit
    private String insertType;

    //Integrated
    private String bottomBracketShellDiameter;
    private Double axleDiameter;
    //Integrated

    //Cartridge
    private Double axleLength;
    private Double shellLength;
    //Cartridge

}
