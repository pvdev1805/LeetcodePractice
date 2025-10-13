package Sorting.problem2273;

// Problem 2273 - Find Resultant Array After Removing Anagrams
// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
// Level: Easy

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // #1. Sorting
    // Time Complexity: O(n * m log m) where n is the number of words and m is the maximum length of a word
    // Space Complexity: O(n) where n is the number of words in the result list
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for(int i = 1; i < n; i++){
            char[] prev = res.get(res.size() - 1).toCharArray();
            char[] curr = words[i].toCharArray();
            Arrays.sort(prev);
            Arrays.sort(curr);
            if(!Arrays.equals(prev, curr)){
                res.add(words[i]);
            }
        }
        return res;
    }
}
