package com.workshop.db.specification;

import com.workshop.enums.PartType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class PartQuerySpecification {

    private PartType partType = PartType.BICYCLE_PART;
    private String brand;
    private String model;
    private String series;
    private String year;
    private String size;
    private String wheelSize;
    private String product;
    private String material;
    private String speeds;
    @JsonIgnore
    private Long userId;
    @JsonIgnore
    private boolean isOfficial;

}
