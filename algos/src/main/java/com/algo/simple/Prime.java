package com.algo.simple;

/**
 * @author preetam
 */
public class Prime {
    private final int number;

    public Prime(int number){
        this.number = number;
    }

    public boolean isPrime(){
        if(number <= 1 )
            return false;
        if(number == 2)
            return true;
        if(number % 2 == 0)
            return false;
        long root = Math.round(Math.sqrt(number));
        for(long i = 3 ; i<=root; i+=2){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
