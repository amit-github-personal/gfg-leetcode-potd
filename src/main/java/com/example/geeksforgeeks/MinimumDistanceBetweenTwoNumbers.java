package com.example.geeksforgeeks;

import java.util.Arrays;

/**
 * @Tagged: Easy
 * @Date: 2 Nov 2023
 *
 * Problem statement.
 *
 * You are given an array a, of n elements.
 * Find the minimum index based distance between two distinct elements of the array, x and y. Return -1, if either x or y does not exist in the array.
 */
public class MinimumDistanceBetweenTwoNumbers {

    public static void main(String[] args) {
        MinimumDistanceBetweenTwoNumbers obj = new MinimumDistanceBetweenTwoNumbers();
        System.out.println(obj.minDist(new int[]{1, 2, 3, 2}, 4, 1, 2));
    }
    int minDist(int a[], int n, int x, int y) {

        var first = -1;
        var second = -1;

        int minDist = n + 1;

        for(var i = 0; i < n; i++) {
            if(a[i] == x) {
                first = i;
            }

            if(a[i] == y) second = i;

            if(first != -1 && second != -1) {
                minDist = Math.min(minDist, second - first);
            }
        }

        if(minDist > n) return -1;

        return minDist;
    }

    private boolean exists(int[] arr, int e) {
        return Arrays.asList(arr).contains(e);
    }
}
