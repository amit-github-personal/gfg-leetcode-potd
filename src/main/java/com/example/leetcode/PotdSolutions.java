package com.example.leetcode;

import java.util.*;

public class PotdSolutions {

    public static void main(String[] args) {
        PotdSolutions solutions = new PotdSolutions();

        System.out.println(solutions.minimiseTheMaximumSumInArray(new int[]{3,5,2,3}));
    }

    /**
     * Tagged: Med
     * Date: 14 Nov 2023
     *
     * Problem Statement
     *
     *Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
     *
     * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
     *
     * A palindrome is a string that reads the same forwards and backwards.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     *
     *     For example, "ace" is a subsequence of "abcde".
     *
     *
     *
     *     Intuition
     *
     * We need to find the number of unique of PalindromicSubsequence, hence repitition is not a case to be done here.
     * Approach
     *
     * For every char $ in [a,b,c...y,z] , a palindrome of type "$ @ $" will exist if there are atleast 2 occurances of "$".
     *
     * Hence we need to find first and last occurance of every char and for every char we need to count unique "@" which represents what characters come in middle of palindrome. This is number of unique characters between FIRST and LAST occurance of "$" char.
     */

    public int countPalindromicSubsequenceOfLength3(String s) {
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int firstOccurrence = s.indexOf(c);
            int lastOccurrence = s.lastIndexOf(c);

            if (firstOccurrence != -1 && lastOccurrence != -1 && firstOccurrence < lastOccurrence) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                result += uniqueChars.size();
            }
        }

        return result;
    }


    /**
     *
     * @Tag: Med
     * @Date: 15 Nov 2023
     *
     * Problem Statement
     *
     *
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i-1] - arr[i]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[arr.length -1];
    }


    /**
     *
     * @Tagged Medium
     * @Date 17 Nov
     *
     * Problem
     * Given an array of even length. Split the array into pairs such that each element is paired.
     *  We have to minimize the max pair sum.
     *
     *  Intuation
     *
     *  To minimise the max sum in the pair we have to take a smaller and a larger integer. The idea
     *  is to sort the array and then pair up elements from left and right and return max from them.
     *
     *  Time O(N)
     *  Space O(1)
     */
    public int minimiseTheMaximumSumInArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length -1;

        int maxSum = Integer.MIN_VALUE;
        while(left < right) {
            int sum = nums[left] + nums[right];
            maxSum = Math.max(sum , maxSum);
            left++;
            right--;
        }

        return maxSum;
    }

}
