package com.workshop.enums;

import com.workshop.db.dto.HeadsetStack;

public class HeadsetStandards {

    // 1/8
    public static final HeadsetStack IS42 = new HeadsetStack(28.6, 42.0, HeadsetType.INTEGRATED);
    // 1/4
    public static final HeadsetStack IS47 = new HeadsetStack(31.8, 47.0, HeadsetType.INTEGRATED);
    // 1/2
    public static final HeadsetStack IS52 = new HeadsetStack(38.1, 52.0, HeadsetType.INTEGRATED);

    // 1/8
    public static final HeadsetStack ZS44 = new HeadsetStack(31.8, 44.1, HeadsetType.SEMI_INTEGRATED);
    // 1/2
    public static final HeadsetStack ZS49 = new HeadsetStack(38.1, 49.7, HeadsetType.SEMI_INTEGRATED);
    public static final HeadsetStack ZS52 = new HeadsetStack(38.1, 52.0, HeadsetType.SEMI_INTEGRATED);
    public static final HeadsetStack ZS56 = new HeadsetStack(38.1, 56.0, HeadsetType.SEMI_INTEGRATED);

}
