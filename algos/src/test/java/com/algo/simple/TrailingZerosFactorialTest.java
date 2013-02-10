package com.algo.simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class TrailingZerosFactorialTest {
    @Test
    public void testFactorialZeroFind(){
        TrailingZerosFactorial t = new TrailingZerosFactorial(100);
        Assert.assertEquals(t.findNumberOfZeroes(),24.0);
    }

    @Test
    public void testFactorialZeroFind2(){
        TrailingZerosFactorial t = new TrailingZerosFactorial(4);
        Assert.assertEquals(t.findNumberOfZeroes(),0.0);
    }
}
