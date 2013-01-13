package com.algo.simple;

/**
 * @author preetam
 */
public class BinarySearch<T extends Comparable> {
    private final T[] array;

    public BinarySearch(T[] array){
        this.array = array;
    }

    public synchronized int search(T target){
        return search(target, 0, array.length-1);
    }

    private int search(T target, int lo, int hi) {
        if(lo > hi){
            return -1;
        }
        int mid = lo+hi >>> 1;
        if(array[mid] == target){
            return mid;
        } else if (array[mid].compareTo(target) < 0){
            return search(target, mid+1, hi);
        } else {
            return search(target, lo, mid-1);
        }
    }
}
