package com.workshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartType {

    FRAME("frame"),
    FORK("fork"),
    DAMPER("damper"),
    DISC("disc"),
    HUB("hub"),
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
    BOTTOM_BRACKET("bottomBracket"),
    SHIFTER_LEFT("shifterLeft"),
    SHIFTER_RIGHT("shifterRight"),
    ROAD_SHIFTER_LEFT("roadShifterLeft"),
    ROAD_SHIFTER_RIGHT("roadShifterRight"),
    GRIPS("grips"),
    HANDLEBAR("handlebar"),
    HEADSET("headset"),
    STEM("stem");

    public final String name;

    public static PartType valueOfName(String name) {
        for (PartType part : values()) {
            if (part.name().equalsIgnoreCase(name)) {
                return part;
            }
        }
        throw new IllegalArgumentException(String.format("No PartType enum constant of name %s", name));
    }
}

