package com.algo.simple;

/**
 * @author preetam
 */
public class MoreMath {
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
