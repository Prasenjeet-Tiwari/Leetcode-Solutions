import java.util.HashMap;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        // Handle the special case for number 1
        int max = 0;
        if (hm.containsKey(1)) {
            int count1 = hm.get(1);
            // The subset length must be odd
            max = (count1 % 2 == 0) ? count1 - 1 : count1;
        }

        // Check sequences for numbers > 1
        for (int x : nums) {
            if (x == 1) continue;
            
            int count = 0;
            long curr = x; // Use long to prevent integer overflow during squaring

            while (hm.containsKey((int) curr)) {
                int val = hm.get((int) curr);
                
                if (val == 1) {
                    count += 1;
                    break;
                } else {
                    count += 2;
                }
                
                curr = curr * curr;
                // Avoid redundant squaring if curr exceeds the possible array element limit
                if (curr > 1000000000) { 
                    break;
                }
            }

            // If the loop exited because the next square wasn't found, 
            // the last element cannot be paired, so it acts as the peak (subtract 1).
            if (count % 2 == 0) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
