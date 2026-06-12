class Solution {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> rowToEliminate= new HashSet<>();
        HashSet<Integer> colToEliminate= new HashSet<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowToEliminate.add(i);
                    colToEliminate.add(j);
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if( rowToEliminate.contains(i) || colToEliminate.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}