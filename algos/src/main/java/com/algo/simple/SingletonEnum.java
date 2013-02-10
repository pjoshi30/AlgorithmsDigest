package com.algo.simple;

/**
 * @author preetam
 */
public enum SingletonEnum  {
    INSTANCE;

    public static SingletonEnum getInstance(){
        return INSTANCE;
    }

}
