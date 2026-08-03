import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // 1. Sort and remove duplicates to ensure strictly increasing subsequence
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[uniqueCount++] = sorted[i];
            }
        }

        // 2. Run LCS between original array and unique sorted array
        int[][] dp = new int[n + 1][uniqueCount + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= uniqueCount; j++) {
                if (nums[i - 1] == sorted[j - 1]) {
                    // Match found: increment subsequence length
                    dp[i][j] = dp[i - 1][j - 1] + 1; 
                } else {
                    // No match: take maximum from top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][uniqueCount];
    }
}
