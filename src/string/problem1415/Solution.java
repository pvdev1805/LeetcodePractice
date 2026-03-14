package string.problem1415;

// Problem 1415 - The k-th Lexicographical String of All Happy Strings of Length n
// Link: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
// Level: Medium

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(N), where N is the length of the happy string we want to generate, since we are iterating through the positions of the string to build it character by character.
    // Space Complexity: O(N), since we are using a StringBuilder to construct the happy string, which can grow up to length N.
    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1)); // Calculate the total number of happy strings of length n, which is 3 choices for the first character and 2 choices for each subsequent character (since it cannot be the same as the previous one), resulting in 3 * 2^(n-1) happy strings.
        if (k > total)
            return ""; // If k is greater than the total number of happy strings, return an empty string as there is no such happy string at position k.

        k--; // Decrement k by 1 to convert it to a zero-based index, since we will be using it to determine the characters in the happy string based on their positions.
        StringBuilder res = new StringBuilder(); // Initialize a StringBuilder to construct the happy string efficiently, as it allows for mutable strings and can be appended to without creating new string instances.
        char last = '\0'; // Initialize a variable to keep track of the last character added to the happy string, starting with a null character to indicate that no characters have been added yet.

        for (int pos = 0; pos < n; pos++) {

            int branch = 1 << (n - pos - 1); // Calculate the number of happy strings that can be formed with the remaining positions after the current position, which is 2 choices for each of the remaining positions, resulting in 2^(n-pos-1) happy strings.

            List<Character> choices = new ArrayList<>();
            for (char c : new char[]{'a', 'b', 'c'})
                if (c != last)
                    choices.add(c); // Generate the list of valid character choices for the current position, which are 'a', 'b', and 'c', but we only add those that are not the same as the last character added to ensure that the happy string does not have consecutive characters.

            int idx = k / branch; // Determine the index of the character to add at the current position based on the value of k and the number of happy strings that can be formed with the remaining positions. This is done by dividing k by the number of happy strings that can be formed with the remaining positions (branch), which gives us the index of the character to choose from the list of valid choices.
            res.append(choices.get(idx)); // Append the chosen character to the result string being constructed.
            last = choices.get(idx); // Update the last character variable to the character that was just added to the happy string, so that we can ensure that the next character chosen is not the same as this one.
            k %= branch; // Update k to be the remainder of k divided by the number of happy strings that can be formed with the remaining positions (branch), which allows us to continue determining the characters for the next positions based on the updated value of k.
        }

        return res.toString();
    }
}
