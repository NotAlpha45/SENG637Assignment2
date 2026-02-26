package org.maheen.assignment2testing;

import org.jfree.data.Range;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for org.jfree.data.Range class Testing methodology: Boundary Value
 * Analysis and Weak Equivalence Class Testing
 *
 * @author Maheen
 */
public class RangeTest {

    //#region getCentralValue() tests
    /**
     *
     * #####################################################
     *
     * Test suite forRange class Method: getCentralValue()
     *
     * #####################################################
     */
    /**
     * Test getCentralValue() with a positive range Equivalence Class: Positive
     * ranges Expected: Returns midpoint (5.0)
     */
    @Test
    public void testGetCentralValueWithPositiveRange() {
        Range range = new Range(2.0, 6.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [2.0, 6.0] should be 4.0",
                4.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a negative range Equivalence Class: Negative
     * ranges Expected: Returns midpoint (-5.0)
     */
    @Test
    public void testGetCentralValueWithNegativeRange() {
        Range range = new Range(-6.0, -2.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [-6.0, -2.0] should be -4.0",
                -4.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a range crossing zero Equivalence Class:
     * Ranges spanning positive and negative values Expected: Returns midpoint
     * (0.0)
     */
    @Test
    public void testGetCentralValueCrossingZero() {
        Range range = new Range(-1.0, 1.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [-1.0, 1.0] should be 0.0",
                0.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with equal lower and upper bounds Boundary Value:
     * Lower == Upper Expected: Returns the same value
     */
    @Test
    public void testGetCentralValueWithEqualBounds() {
        Range range = new Range(5.0, 5.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [5.0, 5.0] should be 5.0",
                5.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with a very small range Boundary Value: Minimum
     * practical range Expected: Returns accurate midpoint despite small values
     */
    @Test
    public void testGetCentralValueWithVerySmallRange() {
        Range range = new Range(0.0000001, 0.0000003);
        double result = range.getCentralValue();
        assertEquals("Central value of range [0.0000001, 0.0000003] should be 0.0000002",
                0.0000002, result, 0.00000001d);
    }

    /**
     * Test getCentralValue() with a large range Boundary Value: Large positive
     * values Expected: Returns accurate midpoint for large numbers
     */
    @Test
    public void testGetCentralValueWithLargeRange() {
        Range range = new Range(-1000000.0, 1000000.0);
        double result = range.getCentralValue();
        assertEquals("Central value of range [-1000000.0, 1000000.0] should be 0.0",
                0.0, result, 0.0000001d);
    }

    /**
     * Test getCentralValue() with decimal precision Boundary Value: Non-integer
     * boundaries Expected: Handles decimal precision correctly
     */
    @Test
    public void testGetCentralValueWithDecimals() {
        Range range = new Range(1.5, 4.5);
        double result = range.getCentralValue();
        assertEquals("Central value of range [1.5, 4.5] should be 3.0",
                3.0, result, 0.0000001d);
    }
    //#endregion

    //#region getLength() tests
    /**
     * *
     * #####################################################
     *
     * Test suite for Range class Method: getLength()
     *
     * #####################################################
     */
    /**
     * Test getLength() with a positive range Equivalence Class: Positive ranges
     * Expected: Returns length (4.0)
     */
    @Test
    public void testGetLengthWithPositiveRange() {
        Range range = new Range(2.0, 6.0);
        double result = range.getLength();
        assertEquals("Length of range [2.0, 6.0] should be 4.0",
                4.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with a negative range Equivalence Class: Negative ranges
     * Expected: Returns positive length (4.0)
     */
    @Test
    public void testGetLengthWithNegativeRange() {
        Range range = new Range(-6.0, -2.0);
        double result = range.getLength();
        assertEquals("Length of range [-6.0, -2.0] should be 4.0",
                4.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with a range crossing zero Equivalence Class: Ranges
     * spanning positive and negative values Expected: Returns total span (10.0)
     */
    @Test
    public void testGetLengthCrossingZero() {
        Range range = new Range(-4.0, 6.0);
        double result = range.getLength();
        assertEquals("Length of range [-4.0, 6.0] should be 10.0",
                10.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with equal lower and upper bounds Boundary Value: Lower
     * == Upper Expected: Returns zero
     */
    @Test
    public void testGetLengthWithEqualBounds() {
        Range range = new Range(5.0, 5.0);
        double result = range.getLength();
        assertEquals("Length of range [5.0, 5.0] should be 0.0",
                0.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with a very small range Boundary Value: Minimum
     * practical range Expected: Returns accurate length for very small values
     */
    @Test
    public void testGetLengthWithVerySmallRange() {
        Range range = new Range(0.0000001, 0.0000005);
        double result = range.getLength();
        assertEquals("Length of range [0.0000001, 0.0000005] should be 0.0000004",
                0.0000004, result, 0.000000001d);
    }

    /**
     * Test getLength() with a large range Boundary Value: Large positive values
     * Expected: Returns accurate length for large numbers
     */
    @Test
    public void testGetLengthWithLargeRange() {
        Range range = new Range(1000000.0, 9000000.0);
        double result = range.getLength();
        assertEquals("Length of range [1000000.0, 9000000.0] should be 8000000.0",
                8000000.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with decimal boundaries Boundary Value: Non-integer
     * boundaries Expected: Handles decimal precision correctly
     */
    @Test
    public void testGetLengthWithDecimals() {
        Range range = new Range(1.5, 4.7);
        double result = range.getLength();
        assertEquals("Length of range [1.5, 4.7] should be 3.2",
                3.2, result, 0.0000001d);
    }

    /**
     * Test getLength() with zero as lower bound Boundary Value: Zero boundary
     * Expected: Returns upper bound value
     */
    @Test
    public void testGetLengthWithZeroLowerBound() {
        Range range = new Range(0.0, 10.0);
        double result = range.getLength();
        assertEquals("Length of range [0.0, 10.0] should be 10.0",
                10.0, result, 0.0000001d);
    }

    /**
     * Test getLength() with zero as upper bound Boundary Value: Zero boundary
     * Expected: Returns absolute value of lower bound
     */
    @Test
    public void testGetLengthWithZeroUpperBound() {
        Range range = new Range(-10.0, 0.0);
        double result = range.getLength();
        assertEquals("Length of range [-10.0, 0.0] should be 10.0",
                10.0, result, 0.0000001d);
    }
    //#endregion
}
