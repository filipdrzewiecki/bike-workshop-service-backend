package com.workshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeadsetType {

    A_HEAD("a-head"),
    SEMI_INTEGRATED("semi-integrated"),
    INTEGRATED("integrated");

    public final String commonName;

    public static HeadsetType valueOfName(String name) {
        for (HeadsetType part : values()) {
            if (part.getCommonName().equalsIgnoreCase(name)) {
                return part;
            }
        }
        throw new IllegalArgumentException(String.format("No Headset enum constant of name %s", name));
    }
}
