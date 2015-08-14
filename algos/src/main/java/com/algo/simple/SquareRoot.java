package com.algo.simple;

public class SquareRoot {
    public static int sqrt(int num){
        int x = (int)Math.pow(2, 16);
        while(true){
            int y = (x + num/x)/2;
            if(y >= x){
                return x;
            }
            x = y;
        }
    }
}
