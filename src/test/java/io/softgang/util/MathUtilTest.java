package io.softgang.util;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class MathUtilTest {

    @Test
    public void testPercentageDifference() {
        double result = MathUtil.percentageDifference(5,10);
        assertTrue(result == 100);
    }

    @Test
    public void testPercentageDifference_whereOldValueGreaterThenNewValue() {
        double result = MathUtil.percentageDifference(10,5);
        assertTrue(result == -50);
    }

    @Test
    public void testPercentageDifference_whereValuesAreTheSame() {
        double result = MathUtil.percentageDifference(5,5);
        assertTrue(result == 0);
    }

    @Test
    public void testPercentageDifference_negativeFormat() {
        double result = MathUtil.percentageDifference(9,5);
        assertTrue(result == -44.44444444444444);
        DecimalFormat df = new DecimalFormat("#.##");
        assertEquals(df.format(result), "-44,44");
    }
}
