package hashMap.problem49;

// Problem 49 - Group Anagrams
// Link: https://leetcode.com/problems/group-anagrams/
// Level: Medium

import java.util.*;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N * K * log K) where N is the number of strings and K is the maximum length of a string
    // Space Complexity: O(N * K)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String sortedStr = new String(word);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
