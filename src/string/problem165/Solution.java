package string.problem165;

// Problem 165 - Compare Version Numbers
// https://leetcode.com/problems/compare-version-numbers/
// Level: Medium

public class Solution {
    // #1. Two Pointers
    // Time Complexity: O(m + n) where m and n are the lengths of version1 and version2 respectively.
    // Space Complexity: O(m + n) for storing the split version strings.
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length;
        int n2 = v2.length;
        int n = Math.max(n1, n2);
        for(int i = 0; i < n; i++){
            int num1 = (i < n1) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < n2) ? Integer.parseInt(v2[i]) : 0;
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
    }

    // #2. Two Pointers without Split
    // Time Complexity: O(m + n) where m and n are the lengths of version
    // Space Complexity: O(1)
    public int compareVersion2(String version1, String version2) {
        int i1 = 0, i2 = 0;
        int n1 = version1.length(), n2 = version2.length();
        while(i1 < n1 || i2 < n2){
            int j1 = i1, j2 = i2;
            while(j1 < n1 && version1.charAt(j1) != '.') j1++;
            while(j2 < n2 && version2.charAt(j2) != '.') j2++;
            int num1 = 0, num2 = 0;
            if (i1 < n1) num1 = Integer.parseInt(version1.substring(i1, j1));
            if (i2 < n2) num2 = Integer.parseInt(version2.substring(i2, j2));
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
            i1 = j1 + 1; // skip the '.'
            i2 = j2 + 1;
        }
        return 0;
    }
}
