package edu.arf4.motivationbalance.dto.converters;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringLocalDateTimeConverter extends StdConverter<String, LocalDateTime>
{
    @Override
    public LocalDateTime convert(String s) {
        if (s == null || s.trim().isEmpty()) return null;
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(LocalDateTimeStringConverter.DATETIME_FORMAT));
    }
}