class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        
        int n = prices.length;
        
        // If k is large, just take every immediate profit (infinite transactions)
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        
        // dp[i][j] represents max profit on day j with at most i transactions
        int[][] dp = new int[k + 1][n];
        
        // Outer loop: iterate through number of transactions
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0]; 
            
            // Inner loop: iterate through the days
            for (int j = 1; j < n; j++) {
                // Choice 1: Do nothing today (same profit as yesterday)
                // Choice 2: Sell today (price today + max profit from previous buy)
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                
                // Track the best day to buy prior to day j
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][n - 1];
    }
}
