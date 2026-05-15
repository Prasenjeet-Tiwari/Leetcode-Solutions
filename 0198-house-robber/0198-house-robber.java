class Solution {
    public int rob(int[] nums) {
        //classic dp refer to striver

        int n = nums.length;

        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int dp[]=new int[n];

        dp[0]=nums[0];    
        dp[1]=Math.max(nums[0],nums[1]); //either start from 1th index or 0th its on you 

        for(int i=2; i<n; i++){
            int inc= nums[i] + dp[i-2];
            int exc= dp[i-1];
            dp[i]= Math.max(inc, exc);
        }        
        
        return dp[n-1];
    }
}