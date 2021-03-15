package edu.arf4.motivationbalance;

import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleTests {

    @Test
    public void test() {

        String DATETIME_FORMAT = "MM-dd-yyyy-HH:mmx";

        OffsetDateTime dt = OffsetDateTime.now();

        String s = dt.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

        System.out.println(s);

        System.out.println(
                OffsetDateTime.parse("03-15-2021-23:44+05", DateTimeFormatter.ofPattern(DATETIME_FORMAT))
        );
    }
}
