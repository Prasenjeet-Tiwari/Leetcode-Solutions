class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;

        int sum = 0;
        for(int m : nums){
            sum += m;
        }
        if(sum < x){
            return -1;
        }
        if(sum == x){
            return n;
        }

        int currSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int m : nums) {
            currSum += m;
        }
        
        int right = 0;

        for (int left = -1; left < n; left++) {
            if (left >= 0) {
                currSum += nums[left];
            }

            while (currSum > x && right < n && right > left) {
                currSum -= nums[right];
                right++;
            }
            

            if (currSum == x) {
                int leftCount = left + 1;
                int rightCount = n - right;
                ans = Math.min(ans, leftCount + rightCount);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
