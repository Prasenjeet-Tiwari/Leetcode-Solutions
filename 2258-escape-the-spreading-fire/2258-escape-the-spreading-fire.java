import java.util.*;

class Solution { 
    public int maximumMinutes(int[][] grid) { 
        int n = grid.length; 
        int m = grid[0].length; 
        
        // 1. First BFS: Calculate exactly when the fire reaches each cell
        int[][] fireTime = new int[n][m];
        for (int[] row : fireTime) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> qFire = new LinkedList<>(); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (grid[i][j] == 1) { 
                    qFire.offer(new int[]{i, j}); 
                    fireTime[i][j] = 0;
                } 
            } 
        } 
        
        int dx[] = {1, -1, 0, 0}; 
        int dy[] = {0, 0, -1, 1}; 
        
        while (!qFire.isEmpty()) {
            int[] curr = qFire.poll();
            int currX = curr[0];
            int currY = curr[1];
            for (int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == 2 || fireTime[newX][newY] != Integer.MAX_VALUE) {
                    continue;
                }
                fireTime[newX][newY] = fireTime[currX][currY] + 1;
                qFire.offer(new int[]{newX, newY});
            }
        }

        // 2. Second BFS: Find the shortest path for the person
        int[][] personTime = new int[n][m];
        for (int[] row : personTime) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>(); 
        q.offer(new int[]{0, 0}); 
        personTime[0][0] = 0;
        
        while (!q.isEmpty()) { 
            int curr[] = q.poll(); 
            int currX = curr[0]; 
            int currY = curr[1]; 
            
            for (int i = 0; i < 4; i++) { 
                int newX = currX + dx[i]; 
                int newY = currY + dy[i]; 
                
                // Fixed your boundary checks (>= n and >= m)
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == 2 || personTime[newX][newY] != Integer.MAX_VALUE) { 
                    continue; 
                } 
                
                // The person can only walk here if they beat the fire
                if (personTime[currX][currY] + 1 <= fireTime[newX][newY]) {
                    personTime[newX][newY] = personTime[currX][currY] + 1;
                    q.offer(new int[]{newX, newY}); 
                }
            } 
        }

        // 3. Evaluate the result based on your arrival at the Safehouse (n-1, m-1)
        if (personTime[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1; // Safehouse is unreachable
        }
        
        if (fireTime[n - 1][m - 1] == Integer.MAX_VALUE) {
            return 1_000_000_000; // Fire can never reach the safehouse
        }
        
        // Calculate the base difference in time
        int diff = fireTime[n - 1][m - 1] - personTime[n - 1][m - 1];
        if (diff < 0) {
            return -1;
        }
        
        // Check neighbors to see if fire blocks you from entering the safehouse at the last second
        boolean personFromLeft = (m > 1 && personTime[n - 1][m - 2] != Integer.MAX_VALUE && fireTime[n - 1][m - 2] - personTime[n - 1][m - 2] > diff);
        boolean personFromTop  = (n > 1 && personTime[n - 2][m - 1] != Integer.MAX_VALUE && fireTime[n - 2][m - 1] - personTime[n - 2][m - 1] > diff);
        
        if (personFromLeft || personFromTop) {
            return diff; 
        }
        
        return diff - 1;
    } 
}
