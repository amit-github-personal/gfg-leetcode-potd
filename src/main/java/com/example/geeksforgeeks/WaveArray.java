package com.example.geeksforgeeks;

/*

@Tag: Easy
@Date: 28 Sept 2023

Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....

If there are multiple solutions, find the lexicographically smallest one.

Note:The given array is sorted in ascending order, and you don't need to return anything to make changes in the original
array itself.

 */
public class WaveArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        convertToWave(arr, arr.length);
        for(int e : arr) System.out.print(e + " ");
    }
    public static void convertToWave(int[] arr, int n) {
        for(int i = 0; i < n -1; i+=2) {
            if(i >= n) break;
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }
    }
}
