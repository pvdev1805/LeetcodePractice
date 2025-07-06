package hashMap.problem1865;

// Problem 1865 - Finding Pairs With a Certain Sum
// Link: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/
// Level: Medium

import java.util.HashMap;

public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> mp = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for(int num : nums2){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        mp.put(nums2[index], mp.get(nums2[index]) - 1);
        nums2[index] += val;
        mp.put(nums2[index], mp.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int cnt = 0;
        for(int num : nums1){
            cnt += mp.getOrDefault(tot - num, 0);
        }
        return cnt;
    }
}