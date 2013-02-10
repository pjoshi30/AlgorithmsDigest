package com.algo.simple;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author preetam
 */
public class RecursiveStringContainsTest {
    @Test
    public void testContains(){
        RecursiveStringContains contains = new RecursiveStringContains("preetam", "tam");
        Assert.assertTrue(contains.contains());
    }

    @Test
    public void testContains2(){
        RecursiveStringContains contains = new RecursiveStringContains("preetam", "m");
        Assert.assertTrue(contains.contains());
    }

    @Test
    public void testContains3(){
        RecursiveStringContains contains = new RecursiveStringContains("preetam", "ee");
        Assert.assertTrue(contains.contains());
    }

    @Test
    public void testNegative(){
        RecursiveStringContains contains = new RecursiveStringContains("preetam", "mat");
        Assert.assertFalse(contains.contains());
    }

    @Test
    public void testNegative2(){
        RecursiveStringContains contains = new RecursiveStringContains("preetam", null);
        Assert.assertFalse(contains.contains());
    }
}
