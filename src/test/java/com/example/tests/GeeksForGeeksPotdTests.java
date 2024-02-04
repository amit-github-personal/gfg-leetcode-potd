package com.example.tests;

import com.example.geeksforgeeks.Solutions;
import com.example.leetcode.PotdSolutions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeeksForGeeksPotdTests {

    private static final Solutions Target = new Solutions();
    private static final PotdSolutions solution = new PotdSolutions();

    @Test
    void shouldReturnCorrectAnswerForLongestArrayDivisibleBy3Or9() {
        int[] arr = new int[]{2, 7, 6, 1, 4, 5};
        int[] other = new int[]{-1, 9 ,0};
        int answer = Target.longSubarrWthSumDivByK(arr, arr.length, 3);
        int otherAns = Target.longSubarrWthSumDivByK(other, other.length, 9);

        Assertions.assertEquals(2, otherAns);
        Assertions.assertEquals(4, answer);
    }

    @Test
    void minSprinklersNeededToWaterAllGarden() {
        int[] arr = new int[]{2, 3, 4, -1, 2, 0, 0, -1, 0};
        int ans = solution.min_sprinklers(arr, arr.length);
        Assertions.assertEquals(-1, ans);
    }
}
