package edu.arf4.motivationbalance;

import edu.arf4.motivationbalance.model.enums.FactorStatus;
import org.junit.Test;

public class MySimpleTests {

    @Test
    public void test() {
        System.out.println(FactorStatus.ACTIVE.getOpposite().name());
        System.out.println(FactorStatus.REMOVED.getOpposite().name());
    }


}
