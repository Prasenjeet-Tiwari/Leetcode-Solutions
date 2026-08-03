class Solution {
    public String stoneGameIII(int[] stoneValue) {
        

        int n=stoneValue.length;

        int dp[]=new int[n+1];

        dp[0]=0;


        // Traverse backwards from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int takeSum = 0;
            
            // A player can take 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {
                takeSum += stoneValue[i + k];
                dp[i] = Math.max(dp[i], takeSum - dp[i + k + 1]);
            }
        }
        
        // dp[0] holds Alice minus Bob score starting from index 0
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}