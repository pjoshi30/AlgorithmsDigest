package com.algo.simple;

import com.google.common.collect.ImmutableSet;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class SieveOfEratosThenesTest {
    @Test
    public void testSieve() {
        SieveOfEratosthenes s = new SieveOfEratosthenes(1000);
        final ImmutableSet<Integer> primes = s.getPrimes();
        Assert.assertFalse(primes.isEmpty());
        System.out.println("Number of primes: "+primes.size());
        Assert.assertTrue(s.isPrime(3));
        Assert.assertFalse(s.isPrime(4));
    }

    @Test
    public void testSieveRange() {
        SieveOfEratosthenes s = new SieveOfEratosthenes(1000);
        final ImmutableSet<Integer> primes = s.getPrimes();
        Assert.assertFalse(primes.isEmpty());
        System.out.println("Number of primes: "+primes.size());
        try {
            Assert.assertTrue(s.isPrime(3));
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("Number not within the range"));
        }
        Assert.assertFalse(s.isPrime(6));
    }
}
