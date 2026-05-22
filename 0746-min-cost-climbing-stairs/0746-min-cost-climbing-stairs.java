class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);

        // dp[i] = min cost to reach step i and step off it
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            // Take min cost of previous two steps and add current step cost
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        // Top floor can be reached from either of the last two steps
        return Math.min(dp[n-1], dp[n-2]);
    }
}