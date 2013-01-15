package com.algo.selects;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation based on http://www.ics.uci.edu/~eppstein/161/960130.html
 * @author preetam
 */
public class QuickSelectUsingMedianOfMedians {

    private Integer[] arr;
    private final int k;
    private final Map<Integer, Integer> map;

    public QuickSelectUsingMedianOfMedians(Integer[] arr, int k){
        this.arr = Arrays.copyOf(arr, arr.length);
        this.k = k;
        this.map = new HashMap<>();
    }

    public int select(){
        return select(0, arr.length, this.k);
    }

    private int select(int start, int end, int k){

        int length = end - start - 1;
        //If the array if less than 10 in size then insertion sort it
        // and return the element at the k'th postion
        if(length <= 10){
            return lessThan10Sort(start, end, k + start);
        }

        //Partition in-place into subsets of 5 elements each
        final Integer[] listArr = partitionSubsets(start, end, length);
        //Find the median of medians
        final int numberOfPartitions = (int) (listArr.length / 2);
        int median = new QuickSelectUsingMedianOfMedians(listArr, numberOfPartitions).select();
        //Partition original array into L1 < median, L2=median and L3 > median
        int posOfMedian = partitionMedian(map.get(median));
        return quick(posOfMedian);
    }

    private int quick(int posOfMedian) {
        if(k < posOfMedian){
            return select(0, posOfMedian, this.k);
        } else if (k > posOfMedian){
            return select(posOfMedian+1, arr.length, this.k-posOfMedian-1);
        } else {
            return arr[posOfMedian];
        }
    }

    private int partitionMedian(int median) {
        return QuickSelect.partition(arr, median);
    }

    private Integer[] partitionSubsets(int start, int end, int length){
        double numPartitions = Math.ceil((length / 5.0));
        Integer[] listArr = new Integer[(int)numPartitions];
        int j = start;
        int increment = 5;
        for(double i = 0; i < numPartitions && (j+increment) <= end; i++ ){
            listArr[(int)i] = select(j, j+increment, 2);
            j+=5;
            increment = (j+5<=end)?5:end-j;
        }
        return listArr;
    }

    private int lessThan10Sort(int start, int end, int k){
        Preconditions.checkArgument(k < arr.length, "Invalid value of k: "+k);
        InsertionSort.sort(arr, start, end);
        map.put(arr[k], k);
        return arr[k];
    }
}
