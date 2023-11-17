package com.example.geeksforgeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solutions to all POTD problems.
 *
 */
public class Solutions {

    public static void main(String[] args) {
        //expected output 6
        //shortest subsequence would be abxycd

        /*

        a -> 0
        b -> 0
        c-> 1
        d -> 1
        x -> 0
        y -> 0

         */
        System.out.println(shortestCommonSupersequence("abcd", "xycd", 4, 4));
    }

    /**
     *
     * @Tagged: Med
     * @Date: 13 Nov 2023
     *
     * Problem Statement
     *
     * Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
     * Note: X and Y can have both uppercase and lowercase letters.
     *
     */
    public static int shortestCommonSupersequence(String X,String Y,int m,int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] d : dp) Arrays.fill(d, -1);

        int solve = solve(X, Y, m, n, dp);
        if(solve == 0) return X.length() + Y.length();
        return (X.length() + Y.length()) - solve;
    }

    private static int solve(String X, String Y, int m, int n, int[][] dp) {
        if(m == 0 || n == 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        if(X.charAt(m - 1) == Y.charAt(n - 1)) {
            return dp[m][n] = 1 + solve(X, Y, m - 1, n - 1, dp);
        } else {
            return dp[m][n] = Math.max(solve(X, Y, m - 1, n, dp), solve(X, Y, m, n - 1, dp));
        }
    }
}
