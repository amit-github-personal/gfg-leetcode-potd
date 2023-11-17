package com.example.leetcode;

/*

@Tag: Medium
@Date: 27 Sept 2023

Problem Statement.

You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time
and the following steps are taken:

    If the character read is a letter, that letter is written onto the tape.
    If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.

Given an integer k, return the kth letter (1-indexed) in the decoded string.
 */
public class DecodedStringAtIndex {

    public static void main(String[] args) {
        System.out.println(decodeForIndex("leet2code3", 10));
    }

    static String decodeForIndex(String s, int k) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(k < res.length()) return String.valueOf(res.toString().charAt(k-1));
            char atIndex = s.charAt(i);
            if(Character.isLetter(atIndex)) {
                res.append(atIndex);
            } else {
                res.append(res.toString().repeat(Integer.parseInt(String.valueOf(atIndex)) -1));
            }
        }

        return String.valueOf(res.toString().charAt(k -1));
    }
}
