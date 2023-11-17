package com.example.leetcode;

/*

@Tag: Easy
@Date: 28 Sept 2023

Problem Statement:

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
 */
public class SortTheArrayByParity {

    public static void main(String[] args) {
        for (int e : sort(new int[]{3,1,2,4})) System.out.println(e + " ");

    }

    /*

    Example 1:
    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    Example 2:

    Input: nums = [0]
    Output: [0]

     */
    static int[] sort(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }
}
