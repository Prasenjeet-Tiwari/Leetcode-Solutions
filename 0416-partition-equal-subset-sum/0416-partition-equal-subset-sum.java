class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i=0; i<n; i++){
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i : nums){
            for (int j=target; j>=i; j--){
                dp[j] = dp[j] || dp[j - i];
            }
        }
        return dp[target];
    }
}