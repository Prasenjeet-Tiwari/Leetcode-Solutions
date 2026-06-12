class Solution {
    public void rotate(int[][] matrix) {

        int n=matrix.length;    //row
        int m=matrix[0].length; //col

        int ans[][]=new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][n-1-j]=matrix[j][i];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j]=ans[i][j];
            }
        }
        
    }
}