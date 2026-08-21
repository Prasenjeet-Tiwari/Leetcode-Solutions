import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // Step 1: Find the maximum element in the array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Store the frequency of each number
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 3: Count how many numbers are divisible by each 'g'
        long[] countDivisible = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                countDivisible[g] += freq[multiple];
            }
        }

        // Step 4: Calculate total pairs using nC2
        long[] exactGcdPairs = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            long totalMultiples = countDivisible[g];
            exactGcdPairs[g] = (totalMultiples * (totalMultiples - 1)) / 2;
        }

        // Step 5: Inclusion-Exclusion (Sieve backwards) to get exact GCD frequencies
        for (int g = maxVal; g >= 1; g--) {
            for (int multiple = 2 * g; multiple <= maxVal; multiple += g) {
                exactGcdPairs[g] -= exactGcdPairs[multiple];
            }
        }

        // Step 6: Create a Prefix Sum array of frequencies
        // This maps the virtual "index ranges" in the sorted gcdPairs array
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + exactGcdPairs[i];
        }

        // Step 7: Answer each query using Binary Search (Upper Bound)
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];
            
            // Binary search to find the smallest GCD 'g' that covers targetIndex
            int low = 1, high = maxVal, ans = maxVal;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > targetIndex) {
                    ans = mid;        // Potential answer, try to find smaller
                    high = mid - 1;
                } else {
                    low = mid + 1;    // Not enough pairs yet, look higher
                }
            }
            answer[i] = ans;
        }

        return answer;
    }
}
