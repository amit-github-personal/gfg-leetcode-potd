package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StringSubsequences {

    public Map<String, Integer> allSubsequencesOfString(String str) {

        Map<String, Integer> subsequences = new HashMap<>();
        getAllSubsequenceOfString(subsequences, str, "");
        return subsequences;
    }

    private void getAllSubsequenceOfString(Map<String, Integer> subsequencesMap, String original, String subsequence) {
        if(original.length() == 0) {
            subsequencesMap.put(subsequence, subsequencesMap.getOrDefault(subsequence, -1) + 1);
        } else {
            //case 1 include the first char in the subsequence
            getAllSubsequenceOfString(subsequencesMap, original.substring(1), subsequence + original.charAt(0));
            //exclude the first char in subsequence
            getAllSubsequenceOfString(subsequencesMap, original.substring(1), subsequence);
        }

    }


    public static void main(String[] args) {
        StringSubsequences stringSubsequences = new StringSubsequences();
        System.out.println(stringSubsequences.allSubsequencesOfString("axxzxy"));
    }
}
