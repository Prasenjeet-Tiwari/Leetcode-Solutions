class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        
        int ans = Integer.MAX_VALUE;
        int curSum = 0;
        int l = 0;
        int minSoFar = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            curSum += arr[r];
            
            while (curSum > target) {
                curSum -= arr[l];
                l++;
            }
            
            if (curSum == target) {
                int curLen = r - l + 1;
                if (l > 0 && dp[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, curLen + dp[l - 1]);
                }
                minSoFar = Math.min(minSoFar, curLen);
            }
            
            dp[r] = minSoFar;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
