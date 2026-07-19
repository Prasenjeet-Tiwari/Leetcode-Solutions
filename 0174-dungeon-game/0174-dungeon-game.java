class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;  
        
        int[][] dp = new int[n][m];
        
        // Loop backwards from the bottom-right corner to the top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                
                // Base case: The destination cell itself
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } 
                // Case: Bottom row (can only move right)
                else if (i == n - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } 
                // Case: Rightmost column (can only move down)
                else if (j == m - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } 
                // Case: General cells (can choose to go right or down)
                else {
                    int minHealthNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, minHealthNeeded - dungeon[i][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}
