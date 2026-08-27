import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Step 1: Try to match the target prefix as long as possible
        int matchLen = 0;
        while (matchLen < n && count[target.charAt(matchLen) - 'a'] > 0) {
            count[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        // Step 2: Backtrack from the longest match to find a valid larger character
        for (int i = matchLen; i >= 0; i--) {
            if (i < n) {
                char tChar = target.charAt(i);
                // Look for the next smallest available character strictly greater than tChar
                for (int c = tChar - 'a' + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        // Found it! Place it and build the result
                        StringBuilder sb = new StringBuilder(target.substring(0, i));
                        sb.append((char) (c + 'a'));
                        count[c]--;

                        // Fill the rest with remaining characters in sorted order
                        for (int r = 0; r < 26; r++) {
                            while (count[r]-- > 0) sb.append((char) (r + 'a'));
                        }
                        return sb.toString();
                    }
                }
            }
            // Put the character back into the pool as we step backward
            if (i > 0) {
                count[target.charAt(i - 1) - 'a']++;
            }
        }
        return ""; // No greater permutation possible
    }
}
