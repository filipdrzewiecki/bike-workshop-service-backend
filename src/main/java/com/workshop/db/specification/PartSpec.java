package com.workshop.db.specification;

import com.workshop.db.entity.BottomBracket;
import com.workshop.db.entity.Frame;
import com.workshop.enums.PartType;
import lombok.Data;


@Data
public class PartSpec {

    private PartType partType;
    private Class clazz;
    private String table;

    private PartSpec(PartType partType, Class clazz, String table) {
        this.partType = partType;
        this.clazz = clazz;
        this.table = table;

    }

    public static final PartSpec FRAME_SPEC = new PartSpec(PartType.FRAME, Frame.class, "frame");
    public static final PartSpec BOTTOM_BRACKET_SPEC = new PartSpec(PartType.BOTTOM_BRACKET, BottomBracket.class, "bottom_bracket");
}
