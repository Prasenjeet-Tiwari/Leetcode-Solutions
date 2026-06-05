import java.util.HashMap;

class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (Character.isLowerCase(curr)) {
                lower[curr - 'a'] = true;
            } else {
                upper[curr - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}

