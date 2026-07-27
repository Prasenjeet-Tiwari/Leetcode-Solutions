class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 1) return s.length();
    
        int n=s.length();
        
        int dp[][]=new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i]=1;
        }

        // Build the table from smaller lengths to larger lengths
        // len is the length of the current substring we are checking
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the current substring

                // If the outer characters match, add 2 to the inner palindrome length
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } 
                // If they don't match, take the max of skipping the left or right character
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // The answer for the entire string is stored in dp[0][n-1]
        return dp[0][n - 1];
    }
}