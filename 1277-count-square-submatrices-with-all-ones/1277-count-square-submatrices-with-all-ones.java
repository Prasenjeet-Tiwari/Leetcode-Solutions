class Solution {
    public int tabulation(int matrix[][]){
        int m=matrix.length;
        int n=matrix[0].length;
        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(matrix[row][col]==0){
                    continue;
                }
                int diag=matrix[row-1][col-1];
                int left=matrix[row][col-1]; 
                int top=matrix[row-1][col];
                matrix[row][col]=Math.min( diag, Math.min(left,top)) +1;
            }
        }
        int ans=0;
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                ans+=matrix[row][col];    
            }               
        }
        return ans;
    }
    
    public int countSquares(int[][] matrix) {
        return tabulation(matrix);
    }
}