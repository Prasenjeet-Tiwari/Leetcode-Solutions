class Solution { 
    public int minMoves(String[] classroom, int energy) { 

        int m = classroom.length; 
        int n = classroom[0].length(); 
        char[][] arr = new char[m][n]; 
        
        int startX = -1, startY = -1; 
        int targetCount = 0; 
        
        int[][] targetId = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                targetId[i][j] = -1;
            }
        }
        
        for (int i = 0; i < m; i++) { 
            String curr = classroom[i]; 
            for (int j = 0; j < n; j++) { 
                char str = curr.charAt(j); 

                if (str == 'S') { 
                    startX = i; 
                    startY = j; 
                } 
                else if (str == 'L') { 
                    targetId[i][j] = targetCount++;
                } 

                arr[i][j] = str; 
            } 
        } 
        
        if (targetCount == 0) { 
            return 0; 
        } 
        
        if (startX == -1 && startY == -1) { 
            return -1; 
        } 
        
        int[] x_dir = {0, 0, 1, -1}; 
        int[] y_dir = {1, -1, 0, 0}; 
        
        int targetMask = (1 << targetCount) - 1;
        
        Queue<int[]> q = new LinkedList<>(); 
        
        q.offer(new int[]{startX, startY, energy, 0, 0}); 
        
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << targetCount];

        visited[startX][startY][energy][0] = true;
        
        while (!q.isEmpty()) { 

            int[] curr = q.poll(); 

            int currX = curr[0]; 
            int currY = curr[1]; 
            int currEnergy = curr[2]; 
            int mask = curr[3];
            int steps = curr[4];
            
            // All litter collected
            if (mask == targetMask) {
                return steps;
            }

            // Reset energy if currently standing on R
            if (arr[currX][currY] == 'R') {
                currEnergy = energy;
            }
            
            // Cannot move with 0 energy unless on R
            if (currEnergy == 0) { 
                continue; 
            } 
            
            for (int i = 0; i < 4; i++) { 

                int newX = currX + x_dir[i]; 
                int newY = currY + y_dir[i]; 
                
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) { 
                    continue; 
                } 
                
                // Correct obstacle check
                if (arr[newX][newY] == 'X') { 
                    continue; 
                }
                
                int nextEnergy = currEnergy - 1;
                
                if (arr[newX][newY] == 'R') {
                    nextEnergy = energy;
                }

                int nextMask = mask;

                // Collect litter
                if (targetId[newX][newY] != -1) {
                    nextMask |= (1 << targetId[newX][newY]);
                }
                
                if (!visited[newX][newY][nextEnergy][nextMask]) { 

                    visited[newX][newY][nextEnergy][nextMask] = true;

                    q.add(new int[]{
                        newX, 
                        newY, 
                        nextEnergy, 
                        nextMask,
                        steps + 1
                    }); 
                }
            } 
        } 
        
        return -1; 
    } 
}
