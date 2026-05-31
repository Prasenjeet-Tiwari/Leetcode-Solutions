class Solution {
    
    public long calculateValue(int nums[], int i) {
        long sum = 0; 
        for (int x : nums) {
            // Actually using the faster integer math this time!
            // This is the exact equivalent of Math.ceil((double)x / i)
            sum += (x + i - 1) / i;
        }
        return sum;
    }

    public int mainFunc(int nums[], int th) {
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        
        int ans = -1;
        int low = 1;  
        int high = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long currTh = calculateValue(nums, mid);
            
            // If the sum is <= threshold, mid is valid.
            if (currTh <= th) {
                ans = mid;         // Record this valid divisor
                high = mid - 1;    // But keep searching for a SMALLER one!
            } else {
                // The sum is too big, which means our divisor was too small.
                low = mid + 1;     // We must increase the divisor.
            }
        }

        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        return mainFunc(nums, threshold);
    }
}