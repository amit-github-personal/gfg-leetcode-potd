package com.example.geeksforgeeks;

import java.util.Arrays;

/**
 * @Tag Medium
 * @Date 21 Sept 2023
 *
 * Problem Statement.
 *
 * Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and
 * follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses.
 * At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but
 * is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if
 * he strictly follows the rule. ith house has a[i] amount of money present in it.
 */
public class TheSticklerTheif {

    public static void main(String[] args) {
        System.out.println(solveForTheSticklerTheif(new int[]{1,5,3}, 5));
    }

    /*

    n = 5
    a[] = {6,5,5,7,4}
    Output:
    15
    Explanation:
    Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6+5+4=15.

    n = 3
    a[] = {1,5,3}
    Output:
    5
    Explanation:
    Loot only 2nd house and get maximum amount of 5.
     */
    static int solveForTheSticklerTheif(int[] houses, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveUsingRecursionWithDp(houses, 0 , dp);
    }

    private static int solveUsingRecursion(int[] houses, int index) {
        if(index >= houses.length) {
            return 0;
        }
        return Math.max(solveUsingRecursion(houses, index + 2) + houses[index], solveUsingRecursion(houses, index + 1));
    }

    private static int solveUsingRecursionWithDp(int[] houses, int index, int[] dp) {
        if(index >= houses.length) {
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        return dp[index] = Math.max(solveUsingRecursionWithDp(houses, index + 2, dp) + houses[index], solveUsingRecursionWithDp(houses, index + 1, dp));
    }
}
