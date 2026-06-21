class Solution {
    public int islandPerimeter(int[][] grid) {

        // Right, Left, Down, Up
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        // Traverse every cell of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int adjacentLand = 0;

                    // Count neighboring land cells that are connected to current
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (ni >= 0 && nj >= 0 &&
                            ni < rows && nj < cols &&
                            grid[ni][nj] == 1) {

                            adjacentLand++;
                        }
                    }

                    // Contribution sides of current land cell in perimeter
                    perimeter += (4 - adjacentLand);
                }
            }
        }

        return perimeter;
    }
}