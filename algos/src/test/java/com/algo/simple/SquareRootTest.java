package com.algo.simple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareRootTest {
    @Test
    public void testSqrt(){
        Assert.assertEquals(SquareRoot.sqrt(81), 9);
        Assert.assertEquals(SquareRoot.sqrt(535824), 732);
    }
}
