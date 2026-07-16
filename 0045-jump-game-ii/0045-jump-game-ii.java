class Solution {
    public int jump(int[] nums) {

        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp, n);
        dp[0]=0;
        for(int i=0; i<n; i++){
            int x=nums[i];
            int limit = Math.min(n - 1, i + x);
            for(int j=i+1; j<=limit; j++){
                dp[j]=Math.min(dp[i]+1, dp[j]);
            }
        }
        return dp[n-1];
        
    }
}