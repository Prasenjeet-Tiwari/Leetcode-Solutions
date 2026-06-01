class Solution {

    // Helper function to count days needed for a given ship capacity
    public int HowManyDays(int[] weights, int capacity) {
        int daysNeeded = 1; // You always need at least 1 day to ship
        int currentLoad = 0;
        
        for (int weight : weights) {
            // If adding this package exceeds capacity, ship leaves!
            if (currentLoad + weight > capacity) {
                daysNeeded++;        // Start a new day
                currentLoad = weight; // This package is the first on tomorrow's ship
            } else {
                currentLoad += weight; // Safely add package to today's ship
            }
        }
        return daysNeeded;
    }

    public int mainFunc(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalSum = 0;
        
        // Find max (left bound) and sum (right bound)
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalSum += weight;
        }
        
        // The boat MUST hold at least the heaviest item, or it can never ship it.
        int left = maxWeight;  
        // The max capacity needed is if we ship everything on day 1.
        int right = totalSum;  
        
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int daysNeeded = HowManyDays(weights, mid);
            
            // If we can ship within the allowed days, this capacity is valid.
            if (daysNeeded <= days) {
                ans = mid;         // Record this valid capacity
                right = mid - 1;   // Try to find a SMALLER, more efficient capacity
            } else {
                // We took too many days. The ship is too small.
                left = mid + 1;    // Increase the capacity
            }
        }
        return ans;
    }

    public int shipWithinDays(int[] weights, int days) {
        return mainFunc(weights, days);
    }
}