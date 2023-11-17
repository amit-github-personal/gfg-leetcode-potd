package com.example.geeksforgeeks;

import java.util.*;

/**
 * @Tagged: Med
 * @Date: 3 Nov 202
 *
 * Problem Statement
 *
 * Given an array arr of n integers, write a function that returns true if there is a triplet (a, b, c) from the array
 * (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.
 */
public class PythagorasTriplets {

    public static void main(String[] args) {
        PythagorasTriplets pythagorasTriplets = new PythagorasTriplets();
        System.out.println(pythagorasTriplets.checkTripletSquaredArr(new int[]{3,8, 5}, 3));
    }

    boolean checkTriplet(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for(int e : arr) list.add(e);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double sqrt = Math.sqrt(arr[i] * arr[i] + arr[j] * arr[j]);
                String[] split = String.valueOf(sqrt).split("\\.");
                if(split.length > 1 && split[1].replace("0", "").length() > 0) continue;

                System.out.println(String.format("Required c %s and checking if it exists in the list %s", sqrt, list.contains(sqrt)));
                if(list.contains((int)sqrt)) return true;
            }
        }
        return false;
    }

    boolean checkTripletSquaredArr(int[] arr, int n) {
        //3, 2, 4, 6, 5
        //9 4 16 36 25
        //4 9 16 25 36


        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        //find max value;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }


        for(int i=max;i>0;i--){
            if(set.contains(i)){
                for(int j=0;j<n;j++){
                    if(arr[j] == max){
                        continue;
                    }
                    if(set.contains(Math.abs(i-arr[j]))){
                        return true;
                    }

                }
            }
        }

        return false;
    }


}
