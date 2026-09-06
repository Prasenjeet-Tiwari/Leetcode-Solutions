class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int n = nums.length;
        int[] small = new int[n];
        
        small[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            small[i] = Math.min(nums[i], small[i + 1]);
        }
        
        int currentMax = nums[0];
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            if (currentMax - small[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}