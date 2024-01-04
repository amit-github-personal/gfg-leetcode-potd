package com.example.leetcode;

import java.util.*;

public class PotdSolutions {

    public static void main(String[] args) {
        PotdSolutions solutions = new PotdSolutions();
        //System.out.println(solutions.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
        //System.out.println(solutions.totalMoneyAtNThDay(20));
//        System.out.println(solutions.numDecodings("06"));
//        System.out.println(solutions.numberOfBeams(new String[]{"000","111","000"}));
        System.out.println(solutions.minOperationToMakeArrayEmpty(new int[]{3,14,3,14,3,14,14,3,3,14,14,14,3,14,14,3,14,14,14,3}));
    }

    /**
     * Tagged: Med
     * Date: 14 Nov 2023
     *
     * Problem Statement
     *
     *Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
     *
     * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
     *
     * A palindrome is a string that reads the same forwards and backwards.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     *
     *     For example, "ace" is a subsequence of "abcde".
     *
     *
     *
     *     Intuition
     *
     * We need to find the number of unique of PalindromicSubsequence, hence repitition is not a case to be done here.
     * Approach
     *
     * For every char $ in [a,b,c...y,z] , a palindrome of type "$ @ $" will exist if there are atleast 2 occurances of "$".
     *
     * Hence we need to find first and last occurance of every char and for every char we need to count unique "@" which represents what characters come in middle of palindrome. This is number of unique characters between FIRST and LAST occurance of "$" char.
     */

    public int countPalindromicSubsequenceOfLength3(String s) {
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int firstOccurrence = s.indexOf(c);
            int lastOccurrence = s.lastIndexOf(c);

            if (firstOccurrence != -1 && lastOccurrence != -1 && firstOccurrence < lastOccurrence) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                result += uniqueChars.size();
            }
        }

        return result;
    }


    /**
     *
     * @Tag: Med
     * @Date: 15 Nov 2023
     *
     * Problem Statement
     *
     *
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i-1] - arr[i]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[arr.length -1];
    }


    /**
     *
     * @Tagged Medium
     * @Date 17 Nov
     *
     * Problem
     * Given an array of even length. Split the array into pairs such that each element is paired.
     *  We have to minimize the max pair sum.
     *
     *  Intuation
     *
     *  To minimise the max sum in the pair we have to take a smaller and a larger integer. The idea
     *  is to sort the array and then pair up elements from left and right and return max from them.
     *
     *  Time O(N)
     *  Space O(1)
     */
    public int minimiseTheMaximumSumInArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length -1;

        int maxSum = Integer.MIN_VALUE;
        while(left < right) {
            int sum = nums[left] + nums[right];
            maxSum = Math.max(sum , maxSum);
            left++;
            right--;
        }

        return maxSum;
    }

    /**
     *
     * @Date: 21 Nov 23
     * @Tag: Med
     *
     * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21.
     * A pair of indices (i, j) is nice if it satisfies all of the following conditions:
     *
     *     0 <= i < j < nums.length
     *     nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
     *
     * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
     *
     */

    public int countNicePairs(int[] nums) {
       var mod = 1000000000 + 7;
//       var ans = 0;

       //bruteforce
//       for(int i = 0; i < nums.length; i++) {
//           for(var j = i + 1; j < nums.length; j++) {
//               var condition = nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]);
//               if(condition) ans = (ans + 1) % mod;
//           }
//       }

        //using map
        //rearrange the values nums[i] = nums[i] - rev(nums[i])
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();;

        for (int n : nums) {
            int rev = rev(n);
            int cur = count.getOrDefault(n - rev, 0);
            count.put(n - rev, cur + 1);
            res = (res + cur) % mod;
        }

        return res;


    }

    public int rev(int num) {
        var rev = new StringBuffer();
        rev.append(num);
        return Integer.parseInt(rev.reverse().toString());
    }


    /**
     *
     * @Tag: Med
     * @Date: 23 Nov 23
     *
     * Problem statement
     *
     * Given array nums of len n and l and r of len m. l and r represent a range/subarray in nums.
     * We need to return the ans for each range/subarray whether they can form an arthematic sequence.
     *
     *  The intuation is to iterate through the l & r array and for each query get the subarray and
     *  try to see if it is an arthemetic sequence.
     *
     *  Time: O(N2) where N is the number of queries
     *  Space: O(N) where N is the no of elements.
     *
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int index = 0;

        List<Boolean> ans = new ArrayList<>();

        while(index < l.length) {
            int[] range = new int[]{l[index], r[index]};
            int subArrLen = (range[1] - range[0]) + 1;
            int[] subarray = new int[subArrLen];
            int counter = 0;
            for(int i = range[0]; i <= range[1]; i++) {
                subarray[counter++] = nums[i];
            }

//            Arrays.sort(subarray);
//
//            boolean isValidArithmaticSubArray = true;
//
//            if(subarray.length > 1) {
//                int expectedDiff = subarray[1] - subarray[0];
//                for(int i = 2; i < subarray.length; i++) {
//                    if(subarray[i] - subarray[i-1] != expectedDiff) {
//                        isValidArithmaticSubArray = false;
//                        break;
//                    }
//                }
//            }
//            ans.add(isValidArithmaticSubArray);

            //Without Sorting
            ans.add(check(subarray));

            index++;
        }

        return ans;
    }

    //Optimised approach without sorting. The idea is to find min and max while iterating through subarray
    // and at the same time insert elements in a set. The idea is to find the diff max - min / n - 1 and adding
    // this diff to min should be available in set if it's a valid arithmetic sequence.
    private Boolean check(int[] subarray) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n : subarray) {
            min = Math.min(min, n);
            max = Math.max(max, n);
            set.add(n);
        }
        //the difference is not equal
        if((max -min) % (subarray.length -1) != 0) return false;
        int diff = (max - min) / (subarray.length -1);
        int curr = min + diff;
        while(curr < max) {
            if(!set.contains(min + diff)) return false;
            curr += diff;
        }
        return true;
    }

    /**
     *
     * Given an array of 3n piles where ith pile shows the number of coins. You have to choose the coins such that
     * - From the pile , alex will pick pile with max coins
     * - You will pick the max coin from remaining pile.
     * - Bob will pick the remainig.
     *
     * Maximise the number of coins you can get.
     *
     *  The approach used in the given code is to sort the piles in ascending order and then select every alternate
     *  pile starting from the second last pile till the pile at index n/3. This is because, in each step,
     *  Alice will choose the pile with the maximum number of coins, so we should not choose the largest piles in the beginning.
     *  Instead, we should choose the second-largest piles so that we can maximize our coins.
     *
     * @param piles arr containing coins at ith pile.
     * @return max no of coins that you could have.
     */
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int count = n / 3;
        int ans = 0;

        for(int i = n - 2; i >= count; i -= 2) {
            System.out.print(piles[i] + " ");
            ans += piles[i];
        }
        return ans;
    }

    public int totalMoneyAtNThDay(int n) {
        int startDay = 1;
        int prevMonday = startDay;
        int sum = 0;
        int counter = 0;

        for(int i = startDay; i <= n; i++) {
            if(counter == 7) {
                startDay = prevMonday + 1;
                prevMonday += 1;
                counter = 0;
            }
            System.out.println("At day " + i + " No : " + startDay);
            sum += startDay;
            startDay += 1;
            counter++;
        }
        return sum;
    }

    /**
     * Given a Binary String consisting 0 & 1 only. We have to return minimum number of operations
     * that we can  make to update the current string so that every 0 & 1s are at alternate
     * position.
     * @param s The input String
     * @return Integer tells min operations required to make the strings equal.
     */
    public int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;

        for(int i = 0; i < s.length(); i++) {
            if( i % 2 == 0) {
                if(s.charAt(i) == '0') {
                   start1++;
                } else {
                    start0++;
                }
            } else {
                if(s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }
        return Math.min(start1, start0);
    }

    public boolean isValid(int code, int len) {
        if (len == 1) {
            return code >= 1 && code <= 26;
        } else {
            return code >= 10 && code <= 26;
        }
    }

    public int countOfDecoding(int i, String s, int[] dp) {
        if (i >= s.length()) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 0;
        if (isValid(s.charAt(i) - '0', 1)) {
            dp[i] += countOfDecoding(i + 1, s, dp);
        }
        if (i < s.length() - 1 && isValid((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0', 2)) {
            dp[i] += countOfDecoding(i + 2, s, dp);
        }
        return dp[i];
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return countOfDecoding(0, s, dp);
    }

    /**
     * The problem involves counting the number of laser beams that can be formed between pairs of security devices
     * in the bank. A laser beam is possible between two devices if there are no security devices in the rows between them.
     * @param bank
     * @return
     */
    public int numberOfBeams(String[] bank) {
        int prevRow = 0;
        int ans = 0;

        for(int i = 0; i < bank.length; i++) {
            int currentRow = 0;
            for(char c : bank[i].toCharArray()) {
                if(c == '1') currentRow++;
            }

            if(prevRow != 0 && currentRow != 0) {
                ans += currentRow * prevRow;
                prevRow = currentRow;
            } else if(prevRow == 0 && currentRow != 0) prevRow = currentRow;
        }

        return ans;
    }

    /**
     * The problem wants us to find out the minimum operations required to make the array empty. The idea is to
     * calculate the freq of each element, then iterate again through the array, if freq of any element is 1 then
     * return -1 otherwise if freq is in 3 multiple find req operation by dividing from 3 otherwise 2.
     *
     * @Date 4 Jan
     * @Tag Med
     * @param nums the input array
     * @return min num of operations required.
     */
    public int minOperationToMakeArrayEmpty(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        int op = 0;
        for(Map.Entry<Integer, Integer> n : freq.entrySet()) {
            Integer freqOfN = n.getValue();
            if(freqOfN == 1) return -1;

            if(freqOfN % 3 == 0) {
                op += freqOfN / 3;
            } else  {
                op += (freqOfN / 3) + 1;
            }
        }
        return op;
    }

}
