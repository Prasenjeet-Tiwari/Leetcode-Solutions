class Solution {

    /*
        TABULATION APPROACH (Bottom-Up DP)

        We start from the second last row
        and move upward.

        Each cell stores:
        current value + minimum of the two possible paths below it.

        ------------------------------------------------

        Example Triangle:

                    2
                   3 4
                  6 5 7
                 4 1 8 3


        Initial DP Matrix:

                2 0 0 0
                3 4 0 0
                6 5 7 0
                4 1 8 3


        ------------------------------------------------
        Processing starts from row = m-2

        Step 1 -> row = 2

            dp[2][0] = 6 + min(4,1) = 7
            dp[2][1] = 5 + min(1,8) = 6
            dp[2][2] = 7 + min(8,3) = 10

        DP becomes:

                2 0 0 0
                3 4 0 0
                7 6 10 0
                4 1 8 3


        ------------------------------------------------
        Step 2 -> row = 1

            dp[1][0] = 3 + min(7,6) = 9
            dp[1][1] = 4 + min(6,10) = 10

        DP becomes:

                2 0 0 0
                9 10 0 0
                7 6 10 0
                4 1 8 3


        ------------------------------------------------
        Step 3 -> row = 0

            dp[0][0] = 2 + min(9,10) = 11

        Final DP:

                11 0 0 0
                 9 10 0 0
                 7  6 10 0
                 4  1  8 3


        Answer = dp[0][0] = 11

        ------------------------------------------------

        Time Complexity  : O(n^2)
        Space Complexity : O(n^2)
    */

    public int tabulation(List<List<Integer>> triangle) {

        // Number of rows
        int m = triangle.size();

        // Last row has maximum columns
        int n = triangle.get(m - 1).size();

        // DP matrix
        int[][] dp = new int[m][n];

        // Copy triangle values into dp matrix

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }

        // Start from second last rowand move upward
    
        for (int row = m - 2; row >= 0; row--) {

            for (int col = 0; col < triangle.get(row).size(); col++) {

                // Minimum path from lower adjacent cells
                int lowerRowMin =Math.min( dp[row + 1][col], dp[row + 1][col + 1]);

                // Current cell value + best possible path below
                dp[row][col] = dp[row][col] + lowerRowMin;
            }
        }

        // Top cell contains minimum path sum
        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        return tabulation(triangle);
    }
}