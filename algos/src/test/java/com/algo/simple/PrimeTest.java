package com.algo.simple;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class PrimeTest {
    @Test
    public void testPrime(){
        Prime p = new Prime(2);
        Assert.assertTrue(p.isPrime());
    }

    @Test
    public void testNotPrime(){
        final Prime prime = new Prime(4618);
        Assert.assertFalse(prime.isPrime());
    }
}
