class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[0]=true;
        for(int i=0;i<n; i++){
            int val=nums[i];
            int limit=Math.min(n-1, i+val);
            if(dp[i]==true){
                for(int j=i+1; j<=limit; j++){
                    dp[j]=true;
                }
            }
        }
        return dp[n-1];
    }
}