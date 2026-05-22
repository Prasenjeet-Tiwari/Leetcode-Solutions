class Solution {

    public int tabulation(int m, int n){
        int dp[][]=new int[m+1][n+1];

        for(int row=1; row<m+1; row++){
            for(int col=1; col<n+1; col++){
                if(row==1 && col==1){
                    dp[row][col]=1;
                    continue;
                }
                dp[row][col]= dp[row-1][col] + dp[row][col-1] ;
            }
        }

        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {

        return tabulation(m, n);
        
    }
}
