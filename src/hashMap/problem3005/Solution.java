package hashMap.problem3005;

// Problem 3005 - Count Elements With Maximum Frequency
// https://leetcode.com/problems/count-elements-with-maximum-frequency
// Level: Easy

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N + M) where N is the length of nums and M is the number of unique elements in nums
    // Space Complexity: O(M) for the HashMap
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxFreq = 0;
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num,0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(num));
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() == maxFreq) count++;
        }
        return count * maxFreq;
    }

    // #2. One Pass with Frequency Array
    // Time Complexity: O(N) where N is the length of nums
    // Space Complexity: O(1) since the frequency array size is fixed (101)
    public int maxFrequencyElements2(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0, count = 0;
        for(int num: nums){
            freq[num]++;
            if(freq[num] > maxFreq){
                count = 1;
                maxFreq = freq[num];
            } else if(freq[num] == maxFreq){
                count++;
            }
        }
        return count * maxFreq;
    }
}
