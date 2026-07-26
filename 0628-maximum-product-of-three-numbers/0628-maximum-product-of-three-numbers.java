class Solution {
    public int maximumProduct(int[] nums) {
        // Track 3 largest numbers
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        // Track 2 smallest numbers (for negatives)
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int n : nums) {
            // Update 3 largest
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            
            // Update 2 smallest
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        
        // Compare product of 3 largest vs 2 smallest + 1 largest
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
