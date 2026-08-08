class Solution {
    public int tabulation(int coins[], int val){
        int m = coins.length;
        int n = val;
        int dp[][] = new int[m + 1][n + 1];
        
        // Initialize all values to a safe "infinity" value to prevent overflow
        // Any value greater than val (like val + 1) is impossible to reach
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                dp[i][j] = val + 1; 
            }
        }
        
        // Base case: 0 total value requires 0 coins
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                int deno = coins[i-1];
                if(j - deno >= 0){
                    int inc = dp[i][j-deno] + 1;
                    int exc = dp[i-1][j];
                    dp[i][j] = Math.min(inc, exc);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        // If the value remains greater than val, it means it's unreachable
        return dp[m][n] > val ? -1 : dp[m][n];
    }
    
    public int coinChange(int[] coins, int amount) {
        return tabulation(coins, amount);
    }
}
