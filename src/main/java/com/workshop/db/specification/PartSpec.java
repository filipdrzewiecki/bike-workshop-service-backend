package com.workshop.db.specification;

import com.workshop.enums.PartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
public class PartSpec<T> {

    PartType partType;
    Class<T> clazz;
    String table;
    String prefix;



}
