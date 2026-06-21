import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Push all rotten oranges to queue & count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, 0 minutes have passed
        if (freshOranges == 0) return 0;

        int minutes = -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: Perform BFS layer by layer
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++; // Increment time for each layer of rotten oranges

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Make it rotten
                        freshOranges--; // Decrement fresh orange count
                        q.offer(new int[]{nr, nc}); // Push to queue
                    }
                }
            }
        }

        // Step 3: Check if all fresh oranges were successfully rotten
        if (freshOranges > 0) return -1;

        return minutes;
    }
}
