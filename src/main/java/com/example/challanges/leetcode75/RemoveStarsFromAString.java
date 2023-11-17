package com.example.challanges.leetcode75;

import java.util.Stack;

/**
 * @Tag: Medium
 *
 * Problem Statement.
 *
 * You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 *
 *     Choose a star in s.
 *     Remove the closest non-star character to its left, as well as remove the star itself.
 *
 * Return the string after all stars have been removed.
 *
 * Note:
 *
 *     The input will be generated such that the operation is always possible.
 *     It can be shown that the resulting string will always be unique.
 */
public class RemoveStarsFromAString {

    public static void main(String[] args) {
        System.out.println(removeStarsWithoutStack("leet**cod*e"));
    }

    /*

    Example 1:

    Input: s = "leet**cod*e"
    Output: "lecoe"
    Explanation: Performing the removals from left to right:
    - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
    - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
    - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
    There are no more stars, so we return "lecoe".

    Example 2:

    Input: s = "erase*****"
    Output: ""
    Explanation: The entire string is removed, so we return an empty string.

     */

    /*
        Classical Stack Problem.
     */
    public static String removeStarsUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character character : s.toCharArray()) {
            if(character == '*') {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(character);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) stringBuilder.append(stack.pop());
        return stringBuilder.reverse().toString();
    }

    public static String removeStarsWithoutStack(String s) {
        String res = "";
        for(Character character : s.toCharArray()) {
            if(character == '*') {
               if(res.length() != 0) res = res.substring(0, res.length() -1);
            } else {
                res += character;
            }
        }

        return res;
    }

    public static String usingTwoPointerFastestApproach(String s) {
        int i = 0, j = 0;
        char[] string = s.toCharArray();
        while(i < s.length()){
            if(string[i] == '*') {
                j--;
            } else {
                string[j++] = string[i];
            }
            i++;
        }
        return new String(string).substring(0, j);
    }
}
