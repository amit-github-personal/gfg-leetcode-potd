package com.example.geeksforgeeks;

/*
@Tag: Medium
@Date: 29 Sept 23

Problem Statement.

You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the
boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 */
public class NumberOfEnclaves {

    public static void main(String[] args) {
        System.out.println(countEdgeBoundaries(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}}));
    }

    /*

    Example 1
    --------------------------------
    Input:
    grid[][] = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}}
    Output:
    3
    Explanation:
    0 0 0 0
    1 0 1 0
    0 1 1 0
    0 0 0 0
    The highlighted cells represents the land cells.

     Example 2 :
     ---------------------------------
     grid[][] = {{0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}}
    Output:
    4
    Explanation:
    0 0 0 1
    0 1 1 0
    0 1 1 0
    0 0 0 1
    0 1 1 0
    The highlighted cells represents the land cells.
     */
    static int countEdgeBoundaries(int[][] grid) {
        int count = 0;

        boolean[][] dp = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(isValidBoundary(i, j, grid, dp)) count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidBoundary(int i, int j, int[][] grid, boolean[][] dp) {
        int k = i;
        while(k < grid.length) {
            if(grid[k][j] == 0) return true;
            k++;
        }

        k = i;

        while(k >= 0) {
            if(grid[k][j] == 0) return true;
            k--;
        }

        k = j;

        while( k < grid[0].length) {
            if(grid[i][k] == 0) return true;
            k++;
        }

        k = j;

        while( k >= 0) {
            if(grid[i][k] == 0) return true;
            k--;
        }

        return false;
    }
}
