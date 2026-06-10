class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int size= grid.length * grid.length; //reason: n*n matrix
        int arr[]= new int[size+1]; //we want 1 based indexing for easy purpose;
        arr[0]=1;

        int rep=-1; int missing=-1;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int val= grid[i][j];
                if(arr[val]==1){
                    rep=val;
                }else{
                    arr[val]=1;
                }
            }
        }
        for(int i=1; i< arr.length; i++){
            if(arr[i]==0){
                missing= i;
                break;
            }
        }
        int out[]=new int[2];
        out[0]=rep;
        out[1]=missing;

        return out;

    }
}