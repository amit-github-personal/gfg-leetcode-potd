package com.example.leetcode;

import java.util.Arrays;

public class MinimumOperationToReduceXToZero {
    /*  You are given an integer array nums and an integer x.
        In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
        Note that this modifies the array for future operations.
        Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

        Example 1:

        Input: nums = [1,1,4,2,3], x = 5 -> [1 1 2 3 4] and requiredSum = 6
        Output: 2
        Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

        Example 2:

        Input: nums = [5,6,7,8,9], x = 4
        Output: -1

        Example 3:

        Input: nums = [3,2,20,1,1,3], x = 10
        Output: 5
        Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
    */

    public static void main(String[] args) {
        System.out.println(countMinOpToReduceXToZero(new int[]{6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119}, 31841));
    }

    public static int countMinOpToReduceXToZero(int[] nums, int x) {
        int target = -x, n = nums.length;
        for (int num : nums) target += num;

        if (target == 0) return n;

        int maxLen = 0, curSum = 0, left = 0;

        for (int right = 0; right < n; ++right) {
            curSum += nums[right];
            while (left <= right && curSum > target) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen != 0 ? n - maxLen : -1;
    }
}
