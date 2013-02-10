package com.algo.simple;

/**
 * @author preetam
 */
public class SingletonLazyBillP {
    private SingletonLazyBillP(){

    }

    private static class Helper{
        public static final SingletonLazyBillP instance = new SingletonLazyBillP();
    }

    public static SingletonLazyBillP getInstance(){
        return Helper.instance;
    }
}
