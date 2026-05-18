class Solution {

    public int tabulation(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // If starting cell is blocked
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Starting point
        dp[0][0] = 1;

        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                // Skip starting cell
                if (row == 0 && col == 0) {
                    continue;
                }

                // If obstacle exists
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Take value from upper cell
                if (row > 0) {
                    up = dp[row - 1][col];
                }

                // Take value from left cell
                if (col > 0) {
                    left = dp[row][col - 1];
                }

                // Total ways
                dp[row][col] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return tabulation(obstacleGrid);
    }
}