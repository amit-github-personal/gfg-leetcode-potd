package com.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*

@Tag: Medium
@Date: 5 Oct 2023

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorityElementII {

    public static void main(String[] args) {
        System.out.println(tryWithConstantSpace(new int[]{1, 2}));
    }

    /*

    Example 1:
    Input: nums = [3,2,3]
    Output: [3]

    Example 2:
    Input: nums = [1]
    Output: [1]

    Example 3:
    Input: nums = [1,2]
    Output: [1,2]

    Constraints:
    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

     */
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int targetFreq = nums.length / 3;

        return freq.entrySet().stream().filter(set -> set.getValue() > targetFreq).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public static List<Integer> tryWithConstantSpace(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);

        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int targetFreq = nums.length / 3;

        int runningEl = nums[0];
        int runningElCount = 1;

        int index = 1;

        while( index < nums.length) {
            if(nums[index] == runningEl) {
                runningElCount++;
                index++;
                continue;
            }

            //2 3 3 3 3 3 4 5

            if(runningElCount > targetFreq) {
                ans.add(runningEl);
                while(index < nums.length && nums[index] == runningEl) index++;
                runningEl = nums[index];
                runningElCount = 1;
                index++;
                continue;
            }

            if(nums[index] != runningEl) {
                runningElCount = 1;
                runningEl = nums[index++];
            }
        }
        if(runningElCount > targetFreq && !ans.contains(runningEl)) ans.add(runningEl);

        return ans;
    }
}
