class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0, max = 0, j = 0;
        int n = s.length();
        HashSet<Character> hm = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            while (hm.contains(c)) {
                hm.remove(s.charAt(j));
                j++;
            }

            hm.add(c);
            count = hm.size();
            max = Math.max(max, count);
        }

        return max;
    }
}