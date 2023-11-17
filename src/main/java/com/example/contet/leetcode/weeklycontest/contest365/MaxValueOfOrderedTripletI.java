package com.example.contet.leetcode.weeklycontest.contest365;

/*

@Tag: Easy

Problem Statement

You are given a 0-indexed integer array nums.
Return the maximum value over all triplets of indices (i, j, k) such that i < j < k.
If all such triplets have a negative value, return 0.

The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
 */
public class MaxValueOfOrderedTripletI {

    /**
     * Bruteforce Apporach
     * @param nums
     * @return
     */
    public long maximumTripletValue(int[] nums) {
        long max = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i= 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    max = Math.max(max, (long)(nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        if(max < 0) return 0;
        return max;
    }

    /*

    The important condition to realize is that i < j < k.

    Thus, we do not need to find any triplet (which could be a harder problem), but a sequential one.

    So, we have one loop for k. Inside that loop, we track:

        max_i - biggest number we found so far.
            note that i must be less than k - 1.
        max_ij - biggest difference nums[i] - nums[j] we found so far.
            note that j must be less than k.

    We track and return the biggest value of max_ij * nums[k].

     */

    public long optimizedSolution(int[] nums) {
        long max = 0;
        long maxij = nums[0] - nums[1], maxI = nums[0];

        for(int i = 2; i < nums.length; ++i) {
            max = Math.max(max, maxij * nums[i]);
            maxI = Math.max(maxI, nums[i -1]);
            maxij = Math.max(maxij, maxI - nums[i]);
        }

        return max;
    }
}
