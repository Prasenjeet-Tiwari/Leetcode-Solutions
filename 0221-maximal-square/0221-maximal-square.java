class Solution {
    public int tabulation(int[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1-indexed DP array handles boundary zeros automatically
        int[][] dp = new int[rows + 1][cols + 1];

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                // matrix is 0-indexed, so we map r->r-1 and c->c-1
                if (matrix[r - 1][c - 1] == 1) {
                    int left = dp[r][c - 1];
                    int diag = dp[r - 1][c - 1];
                    int up = dp[r - 1][c];

                    // Side length is restricted by the smallest neighboring square
                    dp[r][c] = Math.min(up, Math.min(left, diag)) + 1;
                    
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        
        // Return the area of the maximal square
        return maxSide * maxSide;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i][j] = matrix[i][j] - '0'; // Clean way to convert char to int
            }
        }

        return tabulation(arr);
    }
}