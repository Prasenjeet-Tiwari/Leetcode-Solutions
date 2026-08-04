import java.util.Arrays;

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // memo[i][j] stores the max net score player 1 can gain from subarray nums[i...j]
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        // If net score >= 0, Player 1 wins
        return maxNetScore(nums, 0, n - 1, memo) >= 0;
    }

    private int maxNetScore(int[] nums, int start, int end, int[][] memo) {
        // Base case: only one element left
        if (start == end) {
            return nums[start];
        }

        // Return cached result if already calculated
        if (memo[start][end] != Integer.MIN_VALUE) {
            return memo[start][end];
        }

        // Option 1: Choose the start element
        int pickStart = nums[start] - maxNetScore(nums, start + 1, end, memo);
        
        // Option 2: Choose the end element
        int pickEnd = nums[end] - maxNetScore(nums, start, end - 1, memo);

        // Store and return the optimal choice
        memo[start][end] = Math.max(pickStart, pickEnd);
        return memo[start][end];
    }
}
