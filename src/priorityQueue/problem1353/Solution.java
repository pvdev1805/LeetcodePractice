package priorityQueue.problem1353;

// Problem 1353 - Maximum Number of Events That Can Be Attended
// Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// Level: Medium

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    // #1. Sorting + Priority Queue
    // Time Complexity: O(NlogN) for sorting + O(NlogN) for priority queue operations = O(NlogN)
    // Space Complexity: O(N) for the priority queue
    public int maxEvents(int[][] events){
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int day = 0, index = 0, n = events.length, result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pq.isEmpty() || index < n){
            if(pq.isEmpty()){
                day = events[index][0];
            }
            while(index < n && events[index][0] <= day){
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            result++;
            day++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return result;
    }
}
