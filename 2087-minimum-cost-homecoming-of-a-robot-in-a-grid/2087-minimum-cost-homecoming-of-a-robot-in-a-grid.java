import java.util.*;

class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int totalCost = 0;
        
        // 1. Accumulate row costs
        int startRow = startPos[0];
        int homeRow = homePos[0];
        while (startRow != homeRow) {
            // Move closer to the home row
            startRow += (homeRow > startRow) ? 1 : -1;
            totalCost += rowCosts[startRow];
        }
        
        // 2. Accumulate column costs
        int startCol = startPos[1];
        int homeCol = homePos[1];
        while (startCol != homeCol) {
            // Move closer to the home column
            startCol += (homeCol > startCol) ? 1 : -1;
            totalCost += colCosts[startCol];
        }
        
        return totalCost;
    }
}
