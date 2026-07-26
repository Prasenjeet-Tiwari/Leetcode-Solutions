import java.util.Arrays;

class Solution {
    public int minimumDeletions(String word, int k) {
        // Step 1: Count character frequencies
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort frequencies to easily identify valid baselines
        Arrays.sort(freq);
        int ans = Integer.MAX_VALUE;
        
        // Step 2: Try each existing frequency as the minimum allowed frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue; // Skip characters that don't exist
            
            int targetFreq = freq[i];
            int currentDeletions = 0;
            
            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) continue;
                
                if (freq[j] < targetFreq) {
                    // Completely delete characters that fall below our minimum baseline
                    currentDeletions += freq[j];
                } else if (freq[j] > targetFreq + k) {
                    // Trim down characters that exceed the allowable k-threshold
                    currentDeletions += (freq[j] - (targetFreq + k));
                }
            }
            
            ans = Math.min(ans, currentDeletions);
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
