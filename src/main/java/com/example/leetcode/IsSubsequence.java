package com.example.leetcode;

/**
 * @Tag Easy
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
 * of "abcde" while "aec" is not).
 *
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    /**
     * Example 1:
     *
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     *
     * @param seq
     * @param org
     * @return
     */
    public static boolean isSubsequence(String seq, String org) {
        return usingRecursion(seq, org, 0);
    }

    static boolean usingRecursion(String sequence, String original, int index) {
        if(sequence.length() == 0) return true;

        if(index >= original.length()) return false;

        boolean ans = false;

        if(sequence.charAt(0) == original.charAt(index)) {
            ans = ans || usingRecursion(sequence.substring(1), original, index +1);
        } else {
            ans = ans || usingRecursion(sequence, original, index + 1);
        }

        return ans;
    }

    static boolean iterativeApproach(String sequence, String original) {
        int start = 0;

        for(int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == sequence.charAt(start)) start++;
        }

        return start == sequence.length();
    }
}
