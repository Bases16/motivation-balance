package edu.arf4.motivationbalance;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MySimpleTests {

    @Test
    public void test() {
        System.out.println(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm", Locale.US))
        );
    }


}
