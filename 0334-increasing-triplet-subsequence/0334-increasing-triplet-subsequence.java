class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int[] minLeft = new int[n];
        minLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }

        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > minLeft[i] && nums[i] < maxRight[i]) {
                return true;
            }
        }
        return false;
    }
}
