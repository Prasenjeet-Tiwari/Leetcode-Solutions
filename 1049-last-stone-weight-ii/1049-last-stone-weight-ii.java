import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int sum=0;
        int n=stones.length;

        for(int x: stones){
            sum+=x;
        }
        //classic knapsack implementaion my boi

        boolean dp[][]=new boolean[n+1][sum+1];

        for(int i=0; i<n+1; i++){
            dp[i][0]=true;
        }
        
        for(int i=1; i<n+1; i++){
            int val=stones[i-1];
            for(int j=1; j<= sum/2; j++){
                if(val<=j){
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-val];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[stones.length][j]) {
                return sum - 2 * j;
            }
        }
        
        return 0;


    }
}
