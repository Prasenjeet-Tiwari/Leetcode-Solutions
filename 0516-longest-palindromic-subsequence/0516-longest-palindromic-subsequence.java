class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        char[] arr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
/**
Step-by-Step Explanation

Step 1: Handle Base Cases

int n = s.length(); gets the total length of the string.

if (n <= 1) return n; acts as a quick exit. If the string is empty or has only 1 character, the longest palindromic subsequence is just the length of the string itself.

Step 2: Initialize the DP Table

int[][] dp = new int[n][n]; creates a 2D grid. The value at dp[i][j] will represent the longest palindromic subsequence found within the substring starting at index i and ending at index j.

The for loop sets dp[i][i] = 1. This is our foundation: every single character on its own is a palindrome of length 1.

Step 3: Optimize Character Lookups

char[] arr = s.toCharArray(); converts the string into a character array. Looking up values in a primitive array (arr[i]) is slightly faster in Java than calling a method (s.charAt(i)) over and over inside a nested loop.

Step 4: The Dynamic Programming Loops

The Outer Loop (i = n - 1; i >= 0; i--): We iterate the start index i backwards from the end of the string to the beginning. We do this so that when we need to look at an inner substring (which starts at i + 1), its answer has already been calculated and stored in the table.

The Inner Loop (j = i + 1; j < n; j++): We iterate the end index j forwards starting right after i. This represents the right boundary of the substring expanding outwards.

Step 5: Apply the Logic inside the Loops

If the characters match (arr[i] == arr[j]): These two characters form a new outer layer for a palindrome. We take the length of the best palindrome between them (dp[i + 1][j - 1]) and add 2 to it.

If the characters don't match: We can't use both characters at the edges. The best we can do is take the maximum length found by either skipping the left character (dp[i + 1][j]) or skipping the right character (dp[i][j - 1]).

Step 6: Return the Final Answer

return dp[0][n - 1]; grabs the value located at the top-right of our grid. Since 0 is the start of the string and n - 1 is the end, this specific cell holds the answer for the entire string. */