package io.softgang.util;

import java.util.Arrays;

public class CollectionUtil {
    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
        inputStr = inputStr != null ? inputStr : " ";
        String [] inputStrings = inputStr.split(" ");
        return Arrays.stream(inputStrings)
                .anyMatch(word -> Arrays.stream(items)
                        .anyMatch(item -> item.equals(word.toLowerCase().trim())));
    }
}

