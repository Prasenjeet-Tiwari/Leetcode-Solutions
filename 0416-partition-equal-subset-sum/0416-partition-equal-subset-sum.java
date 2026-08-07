class Solution {
    public boolean canPartition(int[] nums) {
        
        Arrays.sort(nums);
        
        int sum=0;
        for(int x: nums){
            sum+=x;
        }

        if(sum%2 !=0){
            return false;
        }
        int halfSum= sum/2;
        int n=halfSum;

        boolean dp[][]=new boolean[nums.length +1][halfSum+1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<nums.length+1; i++){
            int val=nums[i-1];
            for(int j=1; j<=halfSum; j++){
                if(j<val){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j-val] || dp[i-1][j]; 
                }
            }
        } 
        return dp[nums.length][halfSum];
    }
}