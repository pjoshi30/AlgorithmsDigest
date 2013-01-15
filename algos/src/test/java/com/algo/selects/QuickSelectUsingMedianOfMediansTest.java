package com.algo.selects;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author preetam
 */
public class QuickSelectUsingMedianOfMediansTest {
    @Test
    public void testSelect(){
        Integer[] inp = { 4, 5, 1, 3, 7, 2, 9, 8, 6, 17, 89, 77, 101, 54, 76, 34,
                71, 5, 1 };
        Integer[] inp1 = inp.clone();
        Arrays.sort(inp1);
        for(int i=0; i<inp1.length; i++){
            Assert.assertEquals((int)inp1[i],new QuickSelectUsingMedianOfMedians(inp,i).select());
        }
    }
}
