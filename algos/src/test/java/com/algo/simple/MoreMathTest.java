package com.algo.simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class MoreMathTest {
    @Test
    public void testGCD(){
        Assert.assertEquals(MoreMath.gcd(4,8), 4);
    }

    @Test
    public void testLCM(){
        Assert.assertEquals(MoreMath.lcm(4,8), 8);
    }
}
