package com.workshop.db.specification;

import com.workshop.enums.PartType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class GenericSpecification {

    private PartType partType;
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
