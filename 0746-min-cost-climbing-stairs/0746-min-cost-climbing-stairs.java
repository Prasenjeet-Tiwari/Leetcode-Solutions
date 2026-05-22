class Solution {
    public int tabulation(int cost[]){

        int length=cost.length;

        if(length==0) return 0;
        if(length==1) return cost[0];
        if(length==2) return Math.min(cost[0],cost[1]);

        int dp[]=new int[length+1];// cause top i on elevel up with no cost

        dp[0]=cost[0]; dp[1]=cost[1];

        for(int i=2; i<length+1; i++){
            int two=dp[i-2];
            int one=dp[i-1];
            if(i==length){
                dp[i]= Math.min(one,two) + 0; // since ast level cost is 0, not in array
            }else{
                dp[i]= Math.min(one,two) + cost[i];
            }
            
        }
        return dp[length];
    }
    public int minCostClimbingStairs(int[] cost) {
        return tabulation(cost);
    }
}