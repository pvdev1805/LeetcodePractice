package string.problem2138;

// Problem 2138 - Divide a String Into Groups of Size k
// Link: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
// Level: Easy

public class Solution {

    // #1.
    // Time Complexity: O(n/k + k) --> O(k)
    // Space Complexity:
    // - String Array: n/k + 1
    // - int vars: 4
    // - strings in String[]: n
    // - padding last string: k
    // --> Additional space for logic: O(n/k + n + k + 5) --> O(N)
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int limit = n / k;
        int remainder = n % k;
        String[] res = new String[limit + (remainder > 0 ? 1 : 0)];
        for (int i = 0; i < limit; i++) {
            res[i] = s.substring(i * k, (i + 1) * k);
        }
        if (remainder > 0) {
            res[res.length - 1] = s.substring(limit * k);
            res[res.length - 1] += String.valueOf(fill).repeat(k - remainder);
        }
        return res;
    }

    // #2.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String[] divideString2(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() % k != 0) sb.append(fill);

        int n = sb.length();
        String[] res = new String[n / k];
        for (int i = 0; i < n; i += k)
            res[i / k] = sb.substring(i, i + k);

        return res;
    }
}
