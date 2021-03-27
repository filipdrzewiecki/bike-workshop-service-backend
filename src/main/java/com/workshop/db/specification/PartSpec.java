package com.workshop.db.specification;

import com.workshop.enums.PartPrefix;
import com.workshop.enums.PartType;
import lombok.Value;

@Value
public class PartSpec {

    PartType partType;
    Class clazz;
    String table;
    PartPrefix prefix;





}
