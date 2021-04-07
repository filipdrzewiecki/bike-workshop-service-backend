package com.workshop.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PartView {
    @Id
    private Long id;
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
