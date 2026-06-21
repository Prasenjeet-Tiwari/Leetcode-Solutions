class Solution {
    public void dfs(char[][] grid, int x, int y){
        int xCord[]={ 1, -1, 0, 0};
        int yCord[]={ 0, 0, -1, 1};

        grid[x][y]='2';

        int m=grid.length;
        int n= grid[0].length;

        for(int i=0; i<4; i++){
            int newX= x + xCord[i];
            int newY= y + yCord[i];

            if(newX <0 || newX>=m || newY<0 || newY>=n){
                continue;
            }

            if(grid[newX][newY] == '1'){
                dfs( grid, newX, newY);
            }
        }
    }
    public int numIslands(char[][] grid) {

        //basic dsUtil
        int m=grid.length;
        int n= grid[0].length;

        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
        
    }
}