class Solution {
    
    // Added 'k' as a parameter
    public int How_Many_Possible_Adjacent(int bloomDay[], int day, int k) {
        int count = 0;
        int freq = 0; // Number of bouquets made
        
        for (int x : bloomDay) {
            // Flower has bloomed by 'day'
            if (x <= day) {
                count++;
                // Using 'k' i.e batch size
                if (count == k) {
                    freq++;
                    count = 0; // Reset for the next bouquet
                }
            } else {
                // Flower hasn't bloomed, contiguous sequence is broken
                count = 0;
            }
        }
        return freq;
    }

    public int mainFunc(int[] bloomDay, int m, int k) {
        // Base Case & Overflow Trap: Do we even have enough flowers?
        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : bloomDay) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        
        int ans = -1;
        int low = min;
        int high = max;
        
        // The Binary Search Template you've mastered
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int pairs = How_Many_Possible_Adjacent(bloomDay, mid, k);
            
            // If we made enough bouquets, this day is valid.
            if (pairs >= m) {
                ans = mid;         // Record the valid day
                high = mid - 1;    // But try to find an earlier day
            } else {
                // Not enough bouquets. We need to wait more days for flowers to bloom.
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        return mainFunc(bloomDay, m, k);
    }
}