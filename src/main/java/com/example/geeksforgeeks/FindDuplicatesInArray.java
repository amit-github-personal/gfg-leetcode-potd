package com.example.geeksforgeeks;

import java.util.*;

/*

@Tag: Easy

Problem Statement :

Given an array a of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than
once in the given array. Return the answer in ascending order. If no such element is found, return list containing [-1].

Note: The extra space is only for the array to be returned. Try and perform all operations within the provided array.

 */
public class FindDuplicatesInArray {

    public static void main(String[] args) {
        System.out.println(duplicatesWithoutExtraSpace(new int[]{2, 0, 3, 3, 1}, 5));
    }

    /*
    Input:
    N = 4
    a[] = {0,3,1,2}
    Output:
    -1
    Explanation:
    There is no repeating element in the array. Therefore output is -1.

    Input:
    N = 5
    a[] = {2,3,1,2,3}
    Output:
    2 3
    Explanation:
    2 and 3 occur more than once in the given array.
     */
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        countMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> res.add(e.getKey()));
        if(res.isEmpty()) res.add(-1);
        Collections.sort(res);
        return res;
    }

    public static ArrayList<Integer> duplicatesWithoutExtraSpace(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i -1] == arr[i]) {
                if(!res.contains(arr[i])) res.add(arr[i]);
            }
        }
        if(res.isEmpty()) res.add(-1);
        return res;
    }
}
