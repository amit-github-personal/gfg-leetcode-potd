package com.example.tests;

import com.example.leetcode.PotdSolutions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeetCodePOTDTest {
    public  static  final PotdSolutions target = new PotdSolutions();

    @Test
    void findWinners() {
        int[][] arr = new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> answer =
                target.findWinners(arr);
        System.out.println(answer);
    }
}
