package com.algo.selects;

import com.google.common.base.Preconditions;

/**
 * @author preetam
 */
public class QuickSelect {


    public static int partition(Integer[] arr, int numberOfPartitions) {
        Preconditions.checkArgument(numberOfPartitions < arr.length, "Invalid index sepcified, Array length: "+arr.length);
        int pivot = arr[numberOfPartitions];
        swap(arr, numberOfPartitions, arr.length -1);
        int lo = -1;
        int hi = arr.length - 1;
        while(true){
            while(arr[++lo] < pivot){
                if(lo == hi) break;
            }

            while(arr[--hi] > pivot){
                if(hi == lo) break;
            }

            if (lo >= hi) break;

            swap(arr, lo, hi);
        }
        swap(arr, arr.length - 1, hi);
        return hi; // the final position of the pivot
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
