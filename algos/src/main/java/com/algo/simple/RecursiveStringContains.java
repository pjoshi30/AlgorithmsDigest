package com.algo.simple;

import com.google.common.base.Strings;

public class RecursiveStringContains {

    private String originalTarget;
    public boolean contains(String inp, String target) {
        originalTarget = target;
        return containsHelper(inp, target);
    }

    public boolean containsHelper(String inp, String target) {
        if(Strings.isNullOrEmpty(inp) || Strings.isNullOrEmpty(target) || target.length() > inp.length() ){
            return false;
        }

        boolean matched = (inp.charAt(0) == target.charAt(0));

        if( matched && target.length() == 1){
            return true;
        } else if (matched){
            return containsHelper(inp.substring(1, inp.length()), target.substring(1, target.length()));
        }
        return containsHelper(inp.substring(1, inp.length()), originalTarget);
    }

    public static void main(String... args){
        RecursiveStringContains checker = new RecursiveStringContains();

        System.out.println(checker.contains("abate", "bat" ));
        System.out.println(checker.contains("beat", "bat" ));
    }

}
