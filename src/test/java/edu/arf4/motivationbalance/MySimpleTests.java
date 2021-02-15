package edu.arf4.motivationbalance;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MySimpleTests {

    @Test
    public void test() {                             // 21-09-2020-23:55
        System.out.println(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM-dd-yyyy-HH:mm", Locale.US))
        );
    }


}
