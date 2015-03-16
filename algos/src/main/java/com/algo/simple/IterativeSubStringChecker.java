package com.algo.simple;


public class IterativeSubStringChecker {


    boolean isSubstring(String target, String inp){
        if(isNullOrEmpty(target) || isNullOrEmpty(inp)){
            return false;
        }

        for(int i = 0; i < inp.length(); i++){
            boolean matchFound = true;
            for(int j = 0; j < target.length(); j++){
                if(inp.charAt(i+j) != target.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            if(matchFound){
                return true;
            }
        }
        return false;
    }

    private boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String... args){
        IterativeSubStringChecker checker = new IterativeSubStringChecker();

        System.out.println(checker.isSubstring("bat", "abate"));
        System.out.println(checker.isSubstring("bat", "beat"));
    }
}
