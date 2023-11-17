package com.example.challanges.leetcode75;

import java.util.*;

/*

 @Tag: Easy

 Problem Statement.

    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

    Note that the integers in the lists may be returned in any order.

 */
public class DifferenceBetweenTwoArrays {

    public static void main(String[] args) {
        System.out.println(findDifferenceUsingMap(new int[]{1,2,3}, new int[]{2,4,6}));
    }

    /*

    Input: nums1 = [1,2,3], nums2 = [2,4,6]
    Output: [[1,3],[4,6]]
    Explanation:
    For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
    For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

    Example 2:

    Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
    Output: [[3],[]]
    Explanation:
    For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
    Every integer in nums2 is present in nums1. Therefore, answer[1] = [].


     */

    public static List<List<Integer>> findDifferenceUsingMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> presence = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            presence.put(nums1[i], 0);
        }

        for(int i = 0; i < nums2.length; i++) {
            presence.put(nums2[i], presence.getOrDefault(nums2[i], -1) + 1);
        }

        List<Integer> n1 = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(presence.get(nums1[i]) == 0 && !n1.contains(nums1[i])) n1.add(nums1[i]);;
        }

        List<Integer> n2 = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(presence.get(nums2[i]) == 0 && !n2.contains(nums2[i])) {
                n2.add(nums2[i]);
            }
        }

        return List.of(n1, n2);

    }

    public static List<List<Integer>> findDifferenceUsingSet(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        Set<Integer> n1 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            if(set.contains(nums1[i])) n1.add(nums1[i]);;
        }



        return List.of((List<Integer>) n1);

    }
}
