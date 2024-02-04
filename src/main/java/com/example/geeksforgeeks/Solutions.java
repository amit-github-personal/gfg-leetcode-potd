package com.example.geeksforgeeks;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Solutions to all POTD problems.
 *
 */
public class Solutions {


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


    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> pre = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ArrayList<Long> curr = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == i || j == 0) {
                    curr.add(1l);
                } else {
                    long num = (long)((pre.get(j) + pre.get(j-1)) % Math.pow(10, 7));
                    curr.add(num);
                }
            }
            pre = curr;
        }
        return pre;
    }

    int countOccurrencesInRange(int start, int end, int x) {
        AtomicInteger counter = new AtomicInteger();
        for(var num = start + 1; num < end; num++) {
            //System.out.print(num + " ");
            char[] chars = String.valueOf(num).toCharArray();
            Arrays.sort(chars);
            for(char c : chars) if(c - '0' == x) counter.incrementAndGet();
        }
        return counter.get();
    }


    /**
     * Given a grid of m x n dimension which represents a gold mine and each value represents the amount of gold
     * you can extract.
     *
     * We can start any row from first col and move
     *  -> Diagonal UP Right
     *  -> Diagonal BOTTOM Right
     *  -> Right
     *
     *  We need to maximise the amount of hold we can collect.
     */
    static int maxGold(int n, int m, int grid[][]) {
        int col = 0;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, solveForGold(i, col, grid, m, n));
        }
        return ans;
    }

    private static int solveForGold(int row, int col, int[][] grid, int m, int n) {
        //index bound condition
        if(row < 0 || row >= n || col < 0 || col >= m) return 0;

        int ans = 0;
        int[][] paths = {{0, 1}, {-1, 1}, {1, 1}};
        for(int[] path : paths) {
            ans = Math.max(ans, grid[row][col] + solveForGold(row + path[0], col+ path[1], grid, m, n));
        }
        return ans;
    }

    static boolean isValid(int n, int m, int i,int j){
        if(i<0 || j<0 || i>=n || j>=m)  return false;
        return true;
    }

    static int maxGoldIterative(int n, int m, int grid[][]) {

        for(int j = m -2; j >=0; j--) {
            for(int i = 0; i < n; i++) {
                int max = Integer.MIN_VALUE;

                //top right
                if(isValid(n, m, i -1, j + 1)) max = Math.max(grid[i-1][j + 1], max);

                //right
                if(isValid(n, m, i, j + 1)) max = Math.max(grid[i][j + 1], max);

                //bottom right
                if(isValid(n, m, i + 1, j+ 1)) max = Math.max(grid[i + 1][j+ 1], max);

                grid[i][j] += max;
            }
        }

        int ans = 0;
        for(var i = 0; i < n; i++) {
            ans = Math.max(ans, grid[i][0]);
        }
        return ans;
    }

    /**
     * Given a square matrix. Find the determinant Of Matrix.
     *
     * @param matrix
     * @param n
     * @return the determinant of matrix.
     */
    static int determinantOfMatrix(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[][] mat = new int[n - 1][n - 1];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    System.arraycopy(matrix[j], 1, mat[index], 0, n - 1);
                    index++;
                }
            }
            ans += (int) (Math.pow(-1, i) * matrix[i][0] * determinantOfMatrix(mat, n - 1));
        }
        return ans;
    }

    /**
     *
     * The questions says given an array containing elements repeating 3 times. There is exactly one
     * number that repeats only once. We have to return the number.
     *
     * The first thought is to apply sorting, use sliding window.
     * Other is to use HashMap to store count of each number and return the N whose count is 1.
     *
     * @Tag Medium
     * @param arr the input array
     * @param N the length of the array
     * @return int saying which element occurs once.
     */
    static int singleElement(int[] arr , int N) {
        /*
        Arrays.sort(arr);
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < N; windowEnd++) {
            if(windowEnd % 3 != 0) {
                while(windowStart <= windowEnd) {
                    if(arr[windowStart++] != arr[windowEnd]) return arr[windowStart -1];
                }
                windowStart = windowEnd + 1;
            }
        }
        if(windowStart == arr.length -1) return arr[windowStart];
        return 0;
         */

        int ones = 0, twos = 0; // initializing two variables to keep track of bits
        int common_bit_mask; // variable to store common bits

        for (int i = 0; i < N; i++) {
            twos = twos | (ones & arr[i]);

            ones = ones ^ arr[i];

            common_bit_mask = ~(ones & twos);

            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }
        return ones; // return the single element
    }


    /**
     * The problem wants us to find the largest subarray whose sum is
     * divisible by K.
     * @param a the input array.
     * @param n length of input array
     * @param k the divisor.
     * @return len of longest subarray.
     */
    public int longSubarrWthSumDivByK(int a[], int n, int k) {
        //Using Preffix Sum
        Map<Integer, Integer> map = new HashMap<>();
        int preffixSum = 0;
        int maxSubarrayLength = 0;

        for(int i=0; i < n; i++) {
            preffixSum += a[i];
            int rem = preffixSum %k;
            if(rem == 0) {
                maxSubarrayLength = Math.max(maxSubarrayLength, i+1);
            }

            if(rem < 0) rem +=k;

            if(map.containsKey(rem)) {
                maxSubarrayLength = Math.max(i - map.get(rem), maxSubarrayLength);
            } else {
                map.put(rem, i);
            }
        }

        return maxSubarrayLength;
    }
}
