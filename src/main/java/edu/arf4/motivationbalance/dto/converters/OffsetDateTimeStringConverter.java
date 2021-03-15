package edu.arf4.motivationbalance.dto.converters;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeStringConverter extends StdConverter<OffsetDateTime, String> {
    static final String DATETIME_FORMAT = "MM-dd-yyyy-HH:mm";

    @Override
    public String convert(OffsetDateTime offsetDateTime) {
        return offsetDateTime == null ? "" : offsetDateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
