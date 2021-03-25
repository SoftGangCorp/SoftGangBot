package io.softgang.util;

import junit.framework.TestCase;
import org.junit.Test;

public class CollectionUtilTest extends TestCase {
    @Test
    public void testStringContainsItemFromList() {
        String [] test = {"the", "and", "that"};
        boolean contains = CollectionUtil.stringContainsItemFromList("The cat",test);
        assertTrue(contains);
    }
    @Test
    public void testStringContainsItemFromList_Fail() {
        String [] test = {"the", "and", "that"};
        boolean contains = CollectionUtil.stringContainsItemFromList("cat",test);
        assertFalse(contains);
    }
    @Test
    public void testStringContainsItemFromList_Null() {
        String [] test = {"the", "and", "that"};
        boolean contains = CollectionUtil.stringContainsItemFromList(null,test);
        assertFalse(contains);
    }
    @Test
    public void testStringContainsItemFromList_whiteSpace() {
        String [] test = {"the", "and", "that"};
        boolean contains = CollectionUtil.stringContainsItemFromList("theo",test);
        assertFalse(contains);
    }
    @Test
    public void testStringContainsItemFromList_fullWord() {
        String [] test = {"the", "and", "that"};
        boolean contains = CollectionUtil.stringContainsItemFromList("th",test);
        assertFalse(contains);
    }
}