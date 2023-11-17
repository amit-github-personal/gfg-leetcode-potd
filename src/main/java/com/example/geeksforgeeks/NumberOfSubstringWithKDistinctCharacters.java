package com.example.geeksforgeeks;

import java.util.Arrays;

/*

@Tag: Medium
@Date: 5 Oct 2023

Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct)
that have exactly k distinct characters.

 */
public class NumberOfSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(countAllPossibleSubstringWithKDistinctChar("aba", 2));
    }


    /*
    --------------------------------------------------------------------------------------------------------------------
    Input: 1
    S = "aba", K = 2
    Output:
    3
    Explanation:
    The substrings are: "ab", "ba" and "aba".

    Input: 2
    --------------------------------------------------------------------------------------------------------------------
    S = "abaaca", K = 1
    Output:
    7
    Explanation:
    The substrings are: "a", "b", "a", "aa", "a", "c", "a".

     */


    static long  countAllPossibleSubstringWithKDistinctChar(String str, int k) {
        long res = 0;
        boolean[] seen = new boolean[26];
        for(int i = 0; i < str.length(); i++) {
            int distantCount = 0;
            Arrays.fill(seen, false);
            for(int j = i; j < str.length(); j++) {
                if(!seen[str.charAt(j) - 'a']) distantCount++;
                seen[str.charAt(j) - 'a'] = true;
                if(distantCount == k) res++;
            }
        }
        return res;
    }


    /*

    Idea is to use sliding window and maintain a window size which has exactly k distinct characters.
    After you find that you got a window size that has exactly k distinct characters then try decreasing window
    size to see if you still has k distinct character, if yes means there is one more substring.

    aba
     */
    static long  optimizedApproach(String S, int K) {
        return atMostKDistinctChar(S,K)- atMostKDistinctChar(S,K-1);
    }

    static long atMostKDistinctChar(String s, int k){
        int[] arr = new int[26];

        int dist=0;
        int left=0;
        long res=0;

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            if(arr[s.charAt(i)-'a']==1)
                dist++;
            while(dist>k){
                arr[s.charAt(left)-'a']--;
                if(arr[s.charAt(left)-'a']==0)
                    dist--;
                left++;
            }
            res = res+(i-left+1);
        }
        return res;
    }
}
