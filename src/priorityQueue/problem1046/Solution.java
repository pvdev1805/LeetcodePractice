package priorityQueue.problem1046;

// Problem 1046 - Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/
// Level: Easy

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    // #1. Max-Heap (Priority Queue)
    // Time Complexity: O(n log n) where n is the length of the input array
    // Space Complexity: O(n) where n is the length of the input array
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        // Create a max-heap using a priority queue
        // Option 1: Using lambda expression to define the comparator
        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        // Option 2: Using built-in comparator
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            priorityQueue.offer(stone);
        }
        while(priorityQueue.size() > 1){
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();
            if(stone1 != stone2){
                priorityQueue.offer(stone1 - stone2);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}
