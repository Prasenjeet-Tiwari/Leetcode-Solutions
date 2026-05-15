class Solution {

    public int tabulation(int m, int n){
        int dp[][]=new int[m+1][n+1];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][0]=1;
                dp[0][j]=1;
            }
        }

        for(int row=1; row<=m; row++){
            for(int col=1; col<=n; col++){
                dp[row][col]= dp[row-1][col] + dp[row][col-1];
            }
        }

        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {

        return tabulation(m, n);
        
    }
}