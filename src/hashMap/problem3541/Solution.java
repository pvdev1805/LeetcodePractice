package hashMap.problem3541;

// Problem 3541 - Find Most Frequent Vowel and Consonant
// Link: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
// Level: Easy

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. HashMap Frequency Count Approach
    // Time Complexity: O(n * k), where n is the length of the string and k is the number of unique characters.
    // Space Complexity: O(k), where k is the number of unique characters.
    public int maxFreqSum(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;
        String vowels = "aeiou";
        for(char c : s.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            if(vowels.indexOf(c) != -1){
                maxVowelFreq = Math.max(maxVowelFreq, frequency.get(c));
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, frequency.get(c));
            }
        }
        return maxVowelFreq + maxConsonantFreq;
    }

    public int maxFreqSum2(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int con = 0, vow = 0;
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if ("aeiou".indexOf(ch) >= 0)
                vow = Math.max(vow, count);
            else
                con = Math.max(con, count);
        }
        return con + vow;
    }
}
