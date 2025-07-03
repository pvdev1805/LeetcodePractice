package string.problem3304;

public class Solution3 {
    // #3. Bit Manipulation
    // Time Complexity: O(logN) for counting the number of bits in n
    // Space Complexity: O(1) for result variable

    // the number of time that the while loop run = the quantity of bit '1' in the binary representation of n
    public int count_ones(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            ++result;
        }
        return result;
    }

    public char kthCharacter(int k) {
        return (char)('a' + count_ones(k - 1));
    }
}
