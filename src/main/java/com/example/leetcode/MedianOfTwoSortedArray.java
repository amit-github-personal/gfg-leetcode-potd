package com.example.leetcode;

/*
 *
 * @Tag Hard
 * @Date 21 Sept 2023
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * @requiredComplexity O(log (m+n)).
 *
 * */
public class MedianOfTwoSortedArray {
    /*
    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    */

    public static void main(String[] args) {
        System.out.println(medianOfSortedArrayInLinearTimeWithoutMerging(new int[]{1, 3}, new int[]{4, 5, 8, 9}));
    }

    /**
     * Time O(m + n)
     * Space O(m + n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double medianOfSortedArrayInLinearTimeWithMerging(int[] nums1, int[] nums2) {
        int[] finalArr = new int[nums1.length + nums2.length];

        int i = 0, j = 0;

        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                finalArr[index++] = nums1[i++];
            } else {
                finalArr[index++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            finalArr[index++] = nums1[i++];
        }

        while (j < nums2.length) {
            finalArr[index++] = nums2[j++];
        }

        if (finalArr.length % 2 == 0) {
            int left = (finalArr.length / 2) - 1;
            int right = finalArr.length / 2;
            return (double)(finalArr[left] + finalArr[right]) / 2;
        } else {
            return finalArr[finalArr.length / 2];
        }
    }

    /**
     * Time O(m + n)
     * Space O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double medianOfSortedArrayInLinearTimeWithoutMerging(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int combinedLength = m + n;

        int i = 0;
        int j = 0;

        int m1 = 0, m2 = 0;
        for(int k = 0; k <= combinedLength / 2; k++) {
            m2 = m1;

            if(i < n && j < m) {
                m1 = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if( i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        if(combinedLength % 2 == 0) {
            return (double) (m1 + m2 ) / 2;
        } else {
            return m1;
        }
    }

}
