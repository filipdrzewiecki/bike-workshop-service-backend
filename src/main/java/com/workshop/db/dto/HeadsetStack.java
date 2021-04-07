package com.workshop.db.dto;

import com.workshop.enums.HeadsetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadsetStack {

    private double inner;
    private double outer;
    private HeadsetType type;
}
