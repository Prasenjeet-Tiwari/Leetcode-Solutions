class Solution {
    public int longestPalindromeSubseq(String s) {
        // Reverse the original string
        String rev = new StringBuilder(s).reverse().toString();
        
        char[] str1 = s.toCharArray();
        char[] str2 = rev.toCharArray();
        int n = str1.length;

        // DP table for LCS
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    // Characters match
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Mismatch: take max of excluding one char from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}