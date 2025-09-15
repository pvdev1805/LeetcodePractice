package string.problem1935;

// Problem 1935 - Maximum Number of Words You Can Type
// https://leetcode.com/problems/maximum-number-of-words-you-can-type
// Level: Easy

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // #1. String Manipulation
    // Time Complexity: O(N) where N is the length of text
    // Space Complexity: O(1)
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for(char c: brokenLetters.toCharArray()){
            broken[c - 97] = true; // 'a' = 97
        }
        String[] words = text.split(" ");
        int ans = 0;
        for(String word: words){
            boolean canType = true;
            for(char c: word.toCharArray()){
                if(broken[c - 97]){
                    canType = false;
                    break;
                }
            }
            if(canType) ans++;
        }
        return ans;
    }

    // #2. Using HashSet
    // Time Complexity: O(N) where N is the length of text
    // Space Complexity: O(M) where M is the length of brokenLetters
    public int canBeTypedWords2(String text, String brokenLetters) {
        Set<Character> brokenKeys = new HashSet<>();
        for(char c: brokenLetters.toCharArray()){
            brokenKeys.add(c);
        }
        String[] words = text.split(" ");
        int count = 0;
        for(String word: words){
            for(char c: word.toCharArray()){
                if(brokenKeys.contains(c)){
                    count++;
                    break;
                }
            }
        }
        return words.length - count;
    }
}
