import java.util.Arrays;

class Solution { 
    public int findTargetSumWays(int[] nums, int target) { 
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Edge case: if target is impossible to reach within maximum boundaries
        if (Math.abs(target) > sum) return 0;
        
        // 2D DP array because state depends on BOTH index and current sum
        // Sum ranges from -sum to +sum. Size needed: 2 * sum + 1
        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(nums, target, 0, 0, sum, dp); 
    } 

    private int helper(int[] arr, int target, int idx, int currentSum, int totalSum, int[][] dp) { 
        if (idx >= arr.length) {
            return currentSum == target ? 1 : 0;
        }
        
        // Offset negative sums using totalSum to map to non-negative array indices
        if (dp[idx][currentSum + totalSum] != -1) { 
            return dp[idx][currentSum + totalSum]; 
        } 
        
        int subtract = helper(arr, target, idx + 1, currentSum - arr[idx], totalSum, dp); 
        int add = helper(arr, target, idx + 1, currentSum + arr[idx], totalSum, dp); 
        
        dp[idx][currentSum + totalSum] = subtract + add; 
        return dp[idx][currentSum + totalSum]; 
    } 
}
