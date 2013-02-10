package com.algo.simple;

/**
 * Does a recursive check for
 * We can possibly use an inner class (say MyString) and define all the
 * String functions used here inside it - if using any functions of class String is not allowed.
 *
 * @author preetam
 */
public class RecursiveStringContains {

    private final char[] s;
    private final char[] t;

    public RecursiveStringContains(String s, String t) {
        this.s = s == null ? null : s.toCharArray();
        this.t = t == null ? null : t.toCharArray();
    }

    public boolean contains() {
        if (t == null || t.length == 0) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[0]) {
                while (++i < s.length && s[i] != t[0]) ;
            }
            //Found the first element
            int counter = 0;
            for (int k = 0; k < t.length && i < s.length; k++) {
                if (s[i] != t[k]) {
                    continue;
                }
                counter++;
                i++;
            }
            if (counter == t.length) {
                return true;
            }
        }
        return false;
    }

}
