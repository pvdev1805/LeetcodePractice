package bitManipulation.problem1356;

// Problem 1356 - Sort Integers by The Number of 1 Bits
// Link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Custom Sorting with Bit Count
    // Time Complexity: O(N*logN), where N is the length of the input array due to the sorting step. The bit counting for each integer is O(1) since integers are of fixed size (32 bits).
    // Space Complexity: O(N), due to the temporary array used for sorting.
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new); // Convert int[] to Integer[] for sorting
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a); // Count the number of 1 bits in a
            int countB = Integer.bitCount(b); // Count the number of 1 bits in b
            if (countA == countB) return a - b; // If the number of 1 bits is the same, sort by value
            return countA - countB; // Otherwise, sort by the number of 1 bits
        });
        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray(); // Convert back to int[]
    }

    // #2. Custom Sorting with Manual Bit Count
    // Time Complexity: O(N*logN), where N is the length of the input array due to the sorting step. The bit counting for each integer is O(1) since integers are of fixed size (32 bits).
    // Space Complexity: O(N), due to the temporary array used for sorting.
    public int[] sortByBits2(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new); // Convert int[] to Integer[] for sorting
        Arrays.sort(temp, this::compare);
        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray(); // Convert back to int[]
    }

    // Helper method to count the number of 1 bits in an integer using Brian Kernighan's algorithm
    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1); // Remove the least significant bit set to 1
            count++; // Increment the count of 1 bits
        }
        return count;
    }

    // Custom comparator to sort by the number of 1 bits and then by value
    private int compare(int a, int b) {
        int countA = countBits(a); // Count the number of 1 bits in a
        int countB = countBits(b); // Count the number of 1 bits in b
        if (countA == countB) return Integer.compare(a, b); // If the number of 1 bits is the same, compare by value
        return Integer.compare(countA, countB); // Otherwise, compare by the number of 1 bits
    }
}
