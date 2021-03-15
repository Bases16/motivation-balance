package edu.arf4.motivationbalance.dto.converters;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class StringOffsetDateTimeConverter extends StdConverter<String, OffsetDateTime> {

    @Override
    public OffsetDateTime convert(String s) {
        if (s == null || s.trim().isEmpty()) return null;
        return OffsetDateTime.parse(s, DateTimeFormatter.ofPattern(OffsetDateTimeStringConverter.DATETIME_FORMAT));
    }
}
