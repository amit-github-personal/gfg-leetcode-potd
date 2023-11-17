package com.example.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Tag Medium
 * Problem Statement.
 *
 * Given a sorted array arr containing n elements with possibly duplicate is to find indexes of first elements,
 * the task is to find the first and last occurrences of an element x in the given array.
 * Note: If the number x is not found in the array then return both the indices as -1.
 *
 */
public class FirstAndLastOccurrenceOfX {


    public static void main(String[] args) {
        System.out.println(findOccurrence(new int[]{5 ,7 ,7 ,7 ,8 ,8 ,8}, 8));
    }

    /*

    Input:
    n=9, x=5
    arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
    Output:
            2 5
    Explanation:
    First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5.

    Input:
    n=9, x=7
    arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
    Output:
    6 6
    Explanation:
    First and last occurrence of 7 is at index 6.

    */

    static ArrayList<Integer> findOccurrence(int[] arr, int num) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length -1;
        int firstOccurrence = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == num) {
                if(mid != 0 && arr[mid - 1] == num) {
                    right = mid -1;
                } else {
                    firstOccurrence = mid ;
                    break;
                }
            }

            if(arr[mid] > num) {
                right = mid -1;
            }

            if(arr[mid] < num) {
                left = mid + 1;
            }
        }

        if(firstOccurrence == -1) {
            res.addAll(Arrays.asList(-1, -1));
            return res;
        }
        int lastOccurrence = firstOccurrence + 1;
        while(lastOccurrence < arr.length && arr[lastOccurrence] == num ) {
            lastOccurrence++;
        }

        res.addAll(Arrays.asList(firstOccurrence, lastOccurrence -1));
        return res;
    }
}
