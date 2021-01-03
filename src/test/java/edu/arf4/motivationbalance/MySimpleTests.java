package edu.arf4.motivationbalance;

import edu.arf4.motivationbalance.model.enums.FactorStatus;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MySimpleTests {

    @Test
    public void test() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")));
    }


}
