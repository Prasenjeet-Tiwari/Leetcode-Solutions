public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Expand assuming the center is a single character (odd length palindrome)
            int len1 = expandAroundCenter(s, i, i);
            
            // Expand assuming the center is between two characters (even length palindrome)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Take the maximum length found from both expansions
            int len = Math.max(len1, len2);
            
            // If we found a longer palindrome, update the start and end indices
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand outwards from the given center pointers
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The length is (right - left - 1) because the while loop breaks 
        // ONE step after the palindrome condition fails.
        return right - left - 1;
    }
}