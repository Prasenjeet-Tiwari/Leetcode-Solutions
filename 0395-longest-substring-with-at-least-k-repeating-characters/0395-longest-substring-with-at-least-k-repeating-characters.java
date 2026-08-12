import java.util.HashMap;

class Solution { 
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        
        // Count frequencies of each character
        HashMap<Character, Integer> hm = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            hm.put(c, hm.getOrDefault(c, 0) + 1); 
        }
        
        // Find the first character that splits the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.get(c) < k) {
                // Split string around this invalid character
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                
                // Recursively check both parts
                return Math.max(longestSubstring(left, k), longestSubstring(right, k));
            }
        }
        
        // If all characters meet the frequency requirement
        return s.length();
    } 
}
