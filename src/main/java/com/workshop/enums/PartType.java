package com.workshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartType {

    BOTTOM_BRACKET("bottomBracket"),
    BRAKE_HYDRAULIC("brakeHydraulic"),
    BRAKE_CALIPER("brakeCaliper"),
    BRAKE_LEVER("brakeLever"),
    FRAME("frame"),
    FORK("fork"),
    DAMPER("damper"),
    DISC("disc"),
    HUB("hub"),
    PEDALS("pedals"),
    RIM("rim"),
    TYRE("tyre"),
    WHEEL("wheel"),
    SADDLE("saddle"),
    SEATPOST("seatpost"),
    SEATPOST_CLAMP("seatpostClamp"),
    REAR_DERAILLEUR("rearDerailleur"),
    FRONT_DERAILLEUR("frontDerailleur"),
    CRANK("crank"),
    CHAINRING("chainring"),
    CHAIN("chain"),
    CASSETTE("cassette"),
    SHIFTER("shifter"),
    GRIPS("grips"),
    HANDLEBAR("handlebar"),
    HEADSET("headset"),
    STEM("stem"),
    COMMON("common");

    public final String commonName;

    public static PartType valueOfName(String name) {
        for (PartType part : values()) {
            if (part.getCommonName().equalsIgnoreCase(name)) {
                return part;
            }
        }
        throw new IllegalArgumentException(String.format("No PartType enum constant of name %s", name));
    }
}

