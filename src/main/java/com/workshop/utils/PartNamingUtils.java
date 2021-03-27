package com.workshop.utils;

import com.workshop.enums.PartType;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.Frame;
import com.workshop.db.entity.Fork;

import java.util.Map;

@UtilityClass
public class PartNamingUtils {

    private static final String DASH = "-";


    public static String createProductId(BicyclePart part) {
        if (part instanceof Frame) {
            Frame frame = (Frame) part;
            return createProductId(PartType.FRAME, frame.getBrand(), frame.getModel(), frame.getSeries(), frame.getWheelSize(), frame.getSize(), frame.getYear());
        }
        return createGenericProductId(part);
    }

    private static String createGenericProductId(BicyclePart part) {
        PartType type = PartType.valueOfName(part.getProduct());
        String prefix = "XXX";

        StringBuilder builder = new StringBuilder();

        builder.append(prefix);
        builder.append(DASH);

        builder.append(trimToProperLength(part.getBrand(), 5));

        builder.append(trimToProperLength(part.getModel(), 5));

        builder.append(trimToProperLength(part.getSeries(), 5));

        builder.append(trimToProperLength(part.getYear(), 5));

        return removeLastChar(builder.toString().toUpperCase());
    }



    public static String createProductId(PartType type, String brand, String model, String series, String wheelSize, String other1, String other2) {
        StringBuilder builder = new StringBuilder();

        builder.append("XXX");

        builder.append(trimToProperLength(brand, 5));

        builder.append(trimToProperLength(model, 5));

        builder.append(trimToProperLength(series, 5));

        builder.append(trimToProperLength(wheelSize, 2));

        builder.append(trimToProperLength(other1, 5));

        builder.append(trimToProperLength(other2, 5));


        return removeLastChar(builder.toString().toUpperCase());
    }

    private String trimToProperLength(String str, int length) {
        String trimmed = str.length() > length ? str.substring(0, length) : str;
        String removedDots = trimmed.replace(".0", "").replace(",0", "");
        return StringUtils.trimAllWhitespace(removedDots) + DASH;
    }

    private static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }

    private static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }
}
