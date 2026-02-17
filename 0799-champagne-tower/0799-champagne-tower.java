class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        // dp[r][c] = total champagne that reaches glass (r, c)
        // We take 102 just to be safe (max row = 100,
        // and overflow can go to next row)
        double dp[][]=new double[102][102];

        // Initially all champagne is poured into top glass
        dp[0][0]=(double)poured;     

        for(int i=0; i<query_row; i++){
            for(int j=0; j<=i; j++){
                
                 // Amount exceeding capacity
                double curr=Math.max((dp[i][j]-1)/2 , 0);

                dp[i+1][j]+=curr;      // Half goes to left child
                dp[i+1][j+1]+=curr;   // Half goes to left child
            }
        } 

        return Math.min(1, dp[query_row][query_glass]);
    }
}