package com.workshop.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
public abstract class BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NaturalId
    private String productId;

    private String product;
    private String brand;
    private String model;
    private String series;
    private String purpose;

    @Column(precision=7, scale=3)
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal weight;

    private String comment;
    private Boolean isOfficial;
    private String year;

    private String ean;
    private String manufacturersCode;
}
