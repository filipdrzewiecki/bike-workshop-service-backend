package com.workshop.db.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericSpecification {

    private String brand;
    private String model;
    private String series;
    private String year;
    private String size;
    private String wheelSize;
    private String product;
    private String material;
    private String speeds;
}
