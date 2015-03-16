package com.algo.simple;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class RecursiveStringContainsTest {
    @Test
    public void testContains(){
        RecursiveStringContains contains = new RecursiveStringContains();
        Assert.assertTrue(contains.contains("preetam", "tam"));
    }

    @Test
    public void testContains2(){
        RecursiveStringContains contains = new RecursiveStringContains();
        Assert.assertTrue(contains.contains("preetam", "m"));
    }

    @Test
    public void testContains3(){
        RecursiveStringContains contains = new RecursiveStringContains();
        Assert.assertTrue(contains.contains("preetam", "ee"));
    }

    @Test
    public void testNegative(){
        RecursiveStringContains contains = new RecursiveStringContains();
        Assert.assertFalse(contains.contains("preetam", "mat"));
    }

    @Test
    public void testNegative2(){
        RecursiveStringContains contains = new RecursiveStringContains();
        Assert.assertFalse(contains.contains("preetam", null));
    }
}
