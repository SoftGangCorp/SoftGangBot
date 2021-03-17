package io.softgang.util;

public class MathUtil {

    public static double percentageDifference(double oldValue, double newValue) {
        return ((newValue - oldValue)/oldValue) * 100;
    }
}
