package com.algo.simple;

/**
 * @author preetam
 */
public class TrailingZerosFactorial {
    private final int number;

    public TrailingZerosFactorial(int n){
        this.number = n;
    }

    public double findNumberOfZeroes(){
        return findHelper(5, 0);
    }

    private double findHelper(int div, double sum){
        if(number/div < 1){
            return sum;
        }
        sum += Math.floor(number/div);
        return findHelper(div*5, sum);
    }
}
