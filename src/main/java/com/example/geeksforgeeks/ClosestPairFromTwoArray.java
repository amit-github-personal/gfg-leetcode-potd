package com.example.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/*

@Tag: Easy
@Date: 27 Sept 2023

Problem Statement.

Given two sorted arrays arr and brr and a number x, find the pair whose sum is closest to x and the pair has an element
from each array. In the case of multiple closest pairs return any one of them.

Note: Can return the two numbers in any manner.
 */
public class ClosestPairFromTwoArray {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1 ,1 ,1 ,4 ,4 ,5 ,9 ,10}, new int[]{6, 7, 8, 10}, 6));
    }

    /*
    Input : N = 4, M = 4
    arr[ ] = {1, 4, 5, 7}
    brr[ ] = {10, 20, 30, 40}
    X = 32
    Output : 1
    Explanation:
    The closest pair whose sum is closest
    to 32 is {1, 30} = 31.

    Input : N = 4, M = 4
    arr[ ] = {1, 4, 5, 7}
    brr[ ] = {10, 20, 30, 40}
    X = 50
    Output :  3
    Explanation:
    The closest pair whose sum is closest
    to 50 is {7, 40} = 47.

     */
    static ArrayList<Integer> findPairs(int[] arr, int[] brr, int x) {
        ArrayList<Integer> res=new ArrayList<>();
        int i=0, j=brr.length-1, temp=Integer.MAX_VALUE;
        while(i<arr.length && j>=0){
            int sum=arr[i]+brr[j];
            int k=Math.abs(sum-x);
            if(k<temp){
                temp=k;
                if(!res.isEmpty()) res.clear();
                res.add(arr[i]);
                res.add(brr[j]);
            }
            if(sum<x) i++;
            else j--;
        }
        return res;
    }
}
