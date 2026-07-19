class Solution {
    public int countSubstrings(String s) {
        int totalPalindromes = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes (center is at i, i)
            totalPalindromes += expandAndCount(s, i, i);
            
            // Count even-length palindromes (center is at i, i + 1)
            totalPalindromes += expandAndCount(s, i, i + 1);
        }
        
        return totalPalindromes;
    }
    
    private int expandAndCount(String s, int left, int right) {
        int count = 0;
        
        // Expand outwards as long as we are inside the string bounds 
        // and the characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;   // We found a valid palindrome!
            left--;    // Move left pointer left
            right++;   // Move right pointer right
        }
        
        return count;
    }
}