package edu.arf4.motivationbalance.dto.converters;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeStringConverter extends StdConverter<LocalDateTime, String>
{
    static final String DATETIME_FORMAT = "MM-dd-yyyy-HH:mm";

    @Override
    public String convert(LocalDateTime localDatetime) {
        return localDatetime == null ? "" : localDatetime.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }


}
