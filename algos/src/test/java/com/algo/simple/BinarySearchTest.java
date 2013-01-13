package com.algo.simple;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class BinarySearchTest {
    @Test
    public void testBinSearch(){
        Integer[] array = {1,2,3,4,5};
        BinarySearch<Integer> searcher = new BinarySearch<>(array);
        final int result = searcher.search(1);
        Assert.assertTrue(result >= 0);
        Assert.assertEquals(result, 0);
    }
}
