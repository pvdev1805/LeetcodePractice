package hashMap.problem347;

import java.util.*;

public class Solution {
    // #1. HashMap + Max-Heap
    // Time Complexity: O(N log N) where N is the length of nums array
    // Space Complexity: O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> maxHeapComparator =
                (a, b) -> b.getValue() - a.getValue();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(maxHeapComparator);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry); // Add each entry to the max-heap
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll().getKey(); // Extract the key of the entry with the highest frequency
        }
        return result;
    }

    // #2. HashMap + Bucket Sort
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int frequency = entry.getValue();
            freq[frequency].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }

        return new int[0];
    }
}
