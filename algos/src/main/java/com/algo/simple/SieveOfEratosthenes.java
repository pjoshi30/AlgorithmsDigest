package com.algo.simple;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;

/**
 * Finds the set of prime numbers in the given range.
 *
 * @author preetam
 */
public class SieveOfEratosthenes {
    private final boolean[] primes;
    private final int hi;

    public SieveOfEratosthenes(int hi) {
        Preconditions.checkArgument(hi >= 0 , "Invalid range specified");
        this.primes = new boolean[hi + 1];
        Arrays.fill(primes, true);
        this.hi = hi;
        process();
    }

    private void process() {
        primes[0] = primes[1] = false;
        int root = (int) Math.round(Math.sqrt(hi));
        for (int i = 2; i <= root; i++) {
            if (primes[i]) {
                for (int k = i * i; k <= hi; k += i) {
                    primes[k] = false;
                }
            }
        }
    }

    /**
     * Get all the primes in the given range
     *
     * @return ImmutableSet of primes in the specified range
     */
    public ImmutableSet<Integer> getPrimes() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                builder.add(i);
            }
        }
        return builder.build();
    }

    /**
     * Check if a number is prime. If the number is not in the specified range then
     * an IllegalStateException is thrown.
     */
    public boolean isPrime(int num) {
        if (num > hi) {
            throw new IllegalArgumentException("Number not within the range:  0 - " + " hi");
        }
        return primes[num];
    }
}
