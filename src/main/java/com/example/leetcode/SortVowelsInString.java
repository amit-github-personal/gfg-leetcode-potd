package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @Tagged: Med
 * @Date: 14 Nov 2023
 *
 * Problem Statement
 *
 * Given a 0-indexed string s, permute s to get a new string t such that:
 *
 *     All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
 *     The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
 *
 * Return the resulting string.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 */
public class SortVowelsInString {

    public static void main(String[] args) {
        SortVowelsInString vowelsInString = new SortVowelsInString();
        System.out.println(vowelsInString.sortVowels("lEetcOde"));
    }

    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        //Store the vowels in array
        for(Character c : s.toCharArray()) {
            if(isVowel(c)) {
                vowels.add(c);
            }
        }

        //sort the array
        Collections.sort(vowels);

        //create resulting string by iterating original and when found a vowel pull it from array.
        int index = 0;
        StringBuilder resulting = new StringBuilder();
        for(var i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                resulting.append(vowels.get(index++));
            } else {
                resulting.append(s.charAt(i));
            }
        }

        return resulting.toString();
    }

    public boolean isVowel(Character c) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        return vowels.contains(c);
    }
}
