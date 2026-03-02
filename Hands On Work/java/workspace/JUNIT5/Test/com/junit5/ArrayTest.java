package com.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MultipleTestTest {
    Array utils = new Array();
    @Test
    public void testIsEven() {
        assertTrue(utils.isEven(4), "4 should be even");
        assertTrue(utils.isEven(0), "0 should be even");
        assertFalse(utils.isEven(7), "7 should not be even");
        assertFalse(utils.isEven(-3), "-3 should not be even");
    }
    @Test
    public void testIsReversed() {
        int[] original = {1, 2, 3, 4};
        int[] reversed = {4, 3, 2, 1};
        int[] notReversed = {4, 3, 1, 2};
        int[] wrongLength = {4, 3, 2};
        assertTrue(utils.isReversed(original, reversed), "Should return true for a correctly reversed array");
        assertFalse(utils.isReversed(original, notReversed), "Should return false for an incorrectly reversed array");
        assertFalse(utils.isReversed(original, wrongLength), "Should return false for arrays of different lengths");
    }
    @Test
    public void testAdd() {
        assertEquals(5, utils.add(2, 3), "2 + 3 should equal 5");
        assertEquals(-1, utils.add(-4, 3), "-4 + 3 should equal -1");
        assertEquals(0, utils.add(0, 0), "0 + 0 should equal 0");
    }
    @Test
    public void testMultiply() {
        assertEquals(6, utils.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(-12, utils.multiply(-4, 3), "-4 * 3 should equal -12");
        assertEquals(0, utils.multiply(5, 0), "5 * 0 should equal 0");
    }
}
