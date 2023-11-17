package com.example.contet.leetcode.weeklycontest.contest365;

import java.util.Arrays;

/**
 * @Tag: Medium
 */
public class MinimumSizeSubarrayInInfiniteArray {

    public static void main(String[] args) {
        System.out.println(minSizeSubarray(new int[]{1, 2, 3, 4, 5}, 36));
    }

    /*

    Example 1:

    Input: nums = [1,2,3], target = 5
    Output: 2
    Explanation: In this example infinite_nums = [1,2,3,1,2,3,1,2,...].
    The subarray in the range [1,2], has the sum equal to target = 5 and length = 2.
    It can be proven that 2 is the shortest length of a subarray with sum equal to target = 5.

    Example 2:

    Input: nums = [1,1,1,2,3], target = 4
    Output: 2
    Explanation: In this example infinite_nums = [1,1,1,2,3,1,1,1,2,3,1,1,...].
    The subarray in the range [4,5], has the sum equal to target = 4 and length = 2.
    It can be proven that 2 is the shortest length of a subarray with sum equal to target = 4.

    Example 3:

    Input: nums = [2,4,6,8], target = 3
    Output: -1
    Explanation: In this example infinite_nums = [2,4,6,8,2,4,6,8,...].
    It can be proven that there is no subarray with sum equal to target = 3.

    Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 105
    1 <= target <= 109

     */

    public static int minSizeSubarray(int[] nums, int target) {
        long total = Arrays.stream(nums).sum(), sum = 0;
        int n = nums.length, partial = n, complete = n * (int)(target / total), start = 0;
        target %= total;
        for (int end = 0; end < 2 * n; end++) {
            sum += nums[end % n];
            while (sum > target) {
                sum -= nums[start++ % n];
            }
            if (sum == target) {
                partial = Math.min(partial, end - start + 1);
            }
        }
        return partial != n ? partial + complete : -1;
    }
}
