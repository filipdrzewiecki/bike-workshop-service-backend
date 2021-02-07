package com.workshop.component;

import com.workshop.enums.PartType;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BicycleTypePropertyEditor extends PropertyEditorSupport {

    private final List<String> enumNames;


    public BicycleTypePropertyEditor() {
        PartType[] partTypes = PartType.values();
        enumNames = Arrays.stream(partTypes)
                .map(PartType::getCommonName)
                .collect(Collectors.toList());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
            return;
        }
        if (enumNames.contains(text)) {
            PartType type = PartType.valueOfName(text);
            setValue(type);
            return;
        }
        throw new IllegalArgumentException("No enum constant " + PartType.class.getCanonicalName() + " equals ignore case " + text);
    }
}
