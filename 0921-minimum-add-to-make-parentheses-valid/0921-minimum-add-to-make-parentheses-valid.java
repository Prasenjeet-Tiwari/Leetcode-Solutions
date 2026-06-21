class Solution {
    public int minAddToMakeValid(String s) {
        int open= 0;
        int close= 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open> 0) {
                    open--; // Matched a pair
                } else {
                    close++; // Unmatched ')'
                }
            }
        }
        
        return open+ close;
    }
}
