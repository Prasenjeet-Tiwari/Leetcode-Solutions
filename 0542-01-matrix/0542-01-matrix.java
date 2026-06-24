class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        // 1. Initialize Queue with all 0s and set 1s to -1 (unvisited)
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(mat[r][c] == 0){
                    q.add(new int[]{r, c});
                } else {
                    mat[r][c] = -1;
                }
            }
        }
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        // 2. BFS
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            
            for(int i = 0; i < 4; i++){
                int newRow = currRow + dx[i];
                int newCol = currCol + dy[i];
                
                // If the neighbor is within boundaries and unvisited
                if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || mat[newRow][newCol] != -1){
                    continue;
                }

                mat[newRow][newCol] = mat[currRow][currCol] + 1;
                q.offer(new int[]{newRow, newCol});
            }
        }
        return mat;
    }
}
