package com.algo.selects;

import com.google.common.base.Preconditions;

/**
 * @author preetam
 */
public class InsertionSort{

    public static <T extends  Comparable<T>> void sort(T[] arr){
        sort(arr, 0, arr.length);
    }
    /**
     * Sorts a given array
     * @param arr
     */
    public static <T extends Comparable<T>> void sort(T[] arr, int start, int end){
        Preconditions.checkArgument(end > start && start >= 0 && end <= arr.length, "Invalid start and end specified");
        for(int i = start; i < end; i++){
            for(int j =i; j> start; j--){
                if(arr[j-1].compareTo(arr[j]) > 0){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int j, int k) {
        T temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}
