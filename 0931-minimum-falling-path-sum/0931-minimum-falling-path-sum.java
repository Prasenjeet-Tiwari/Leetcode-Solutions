class Solution {
    public int tabulation(int matrix[][]){
        // why waste time in making matrix. 
        //let's just use the given one

        int row=matrix.length;
        int col=row; //since N x N

        for(int r=1; r<row; r++){   //start form 2nd row
            for(int c=0; c<col; c++){
                int up=matrix[r-1][c];
                int leftDiag= c-1>=0?   matrix[r-1][c-1] : Integer.MAX_VALUE;
                int rightDiag= c+1<col? matrix[r-1][c+1]  : Integer.MAX_VALUE;

                matrix[r][c] += Math.min(up , Math.min(leftDiag , rightDiag));
            }
        }

        int minimum = Integer.MAX_VALUE;
        for(int c=0; c<col; c++){
            minimum= Math.min(minimum , matrix[row-1][c]); //scan each col of last row
        }
        return minimum;
    }
    public int minFallingPathSum(int[][] matrix) {

        return tabulation(matrix);
    }
}