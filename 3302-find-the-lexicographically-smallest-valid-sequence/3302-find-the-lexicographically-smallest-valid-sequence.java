class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];
        int j = m - 1;

        // Match word2 from the end
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Greedily choose indices
        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            }

            // Use one mismatch
            else if (dp[i + 1] >= m - j - 1) {
                ans[j++] = i++;
                break;
            }

            i++;
        }

        // Match remaining characters exactly
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}