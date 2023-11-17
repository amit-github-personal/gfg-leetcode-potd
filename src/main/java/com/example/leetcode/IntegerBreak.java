package com.example.leetcode;

/*

@Tag: Medium
@Date: 6 Oct 2019

Problem Statement

Given an integer n, break it into the sum of k positive integers,
where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(24));
    }

    /*
        Example 1:
        Input: n = 2
        Output: 1
        Explanation: 2 = 1 + 1, 1 × 1 = 1.

        Example 2:
        Input: n = 10
        Output: 36
        Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
        2 <= n <= 58
    */

    // 1 + 2 = 3
    //2 + 2 -> 4
    //3 + 2 = 6
    //3 + 3 = 9
    // 4 + 3 = 12
    //3 + 3 + 2 = 8
    //2 + 3 + 4 = 24
    // 3 + 3 + 4 = 36

   // 24 -> 3  + 3 + 3 + 3 + 3 + 3 + 3 + 3


    static int integerBreak(int n) {
        int temp = n;
        int sum = 0;
        int res = 1;

        while(sum < n) {
            if (temp % 3 == 0) {
                sum += 3;
                res *= 3;
                temp -= 3;
            } else {
                sum += 2;
                res *= 2;
                temp -= 2;
            }
        }
        return res;
    }

    static int otherWay(int n ) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int count_of_3s = n / 3;
        int remainder = n % 3;

        if (remainder == 0) {
            return (int) Math.pow(3, count_of_3s);
        } else if (remainder == 1) {
            return (int) Math.pow(3, count_of_3s - 1) * 4;
        } else {
            return (int) Math.pow(3, count_of_3s) * 2;
        }
    }
}
