package org.maheen.assignment2testing;

import org.jfree.data.Range;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for org.jfree.data.Range class
 * Testing methodology: Boundary Value Analysis and Weak Equivalence Class
 * Testing
 * 
 * @author Maheen
 */
public class RangeTest {

    // ==================== getCentralValue() Tests ====================

    /**
     * Test getCentralValue() with a positive range
     * Equivalence Class: Positive ranges
     * Expected: Returns midpoint (5.0)
     */
    @Test
    public void testGetCentralValueWithPositiveRange() {
        Range range = new Range(2.0, 6.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [2.0, 6.0] should be 4.0",
                4.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a negative range
     * Equivalence Class: Negative ranges
     * Expected: Returns midpoint (-5.0)
     */
    @Test
    public void testGetCentralValueWithNegativeRange() {
        Range range = new Range(-6.0, -2.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [-6.0, -2.0] should be -4.0",
                -4.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a range crossing zero
     * Equivalence Class: Ranges spanning positive and negative values
     * Expected: Returns midpoint (0.0)
     */
    @Test
    public void testGetCentralValueCrossingZero() {
        Range range = new Range(-1.0, 1.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [-1.0, 1.0] should be 0.0",
                0.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with equal lower and upper bounds
     * Boundary Value: Lower == Upper
     * Expected: Returns the same value
     */
    @Test
    public void testGetCentralValueWithEqualBounds() {
        Range range = new Range(5.0, 5.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [5.0, 5.0] should be 5.0",
                5.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a very small range
     * Boundary Value: Minimum practical range
     * Expected: Returns accurate midpoint despite small values
     */
    @Test
    public void testGetCentralValueWithVerySmallRange() {
        Range range = new Range(0.0000001, 0.0000003);
        double result = range.getCentralValue();
        assertEquals("Central value of range [0.0000001, 0.0000003] should be 0.0000002",
                0.0000002, result, 0.00000001d);
    }

    /**
     * Test getCentralValue() with a large range
     * Boundary Value: Large positive values
     * Expected: Returns accurate midpoint for large numbers
     */
    @Test
    public void testGetCentralValueWithLargeRange() {
        Range range = new Range(1000000.0, -1000000.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [1000000.0, -1000000.0] should be 0.0",
                0.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with decimal precision
     * Boundary Value: Non-integer boundaries
     * Expected: Handles decimal precision correctly
     */
    @Test
    public void testGetCentralValueWithDecimals() {
        Range range = new Range(1.5, 4.5);
        double result = range.getCentralValue();
        assertEquals("Central value of range [1.5, 4.5] should be 3.0",
                3.0, result, 0.0000001d);
    }
}
