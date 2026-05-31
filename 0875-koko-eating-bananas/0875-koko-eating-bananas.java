class Solution {
    // 1. Change return type to long
    public long hoursTaken(int piles[], int i) {
        long hours = 0; 
        for (int x : piles) {
            // 2. Faster integer math equivalent to Math.ceil((double)x / i)
            hours += (x + i - 1) / i;
        }
        return hours;
    }

    public int mainFunc(int piles[], int h) {
        int max = Integer.MIN_VALUE;
        for (int x : piles) {
            max = Math.max(max, x);
        }
        int ans = max;

        int low = 1;  // note
        int high = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // 3. Catch the result as a long
            long timeTaken = hoursTaken(piles, mid);
            
            if (timeTaken <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        return mainFunc(piles, h);
    }
}