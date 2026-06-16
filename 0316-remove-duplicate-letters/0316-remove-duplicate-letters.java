class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            int index = c - 'a';
            freq[index]--;
            if(seen[index]) continue;
            while(!st.isEmpty() && st.peek()>c && freq[st.peek() - 'a'] > 0){
                seen[st.pop() - 'a'] = false;
            }
            st.push(c);
            seen[index] = true;
        }
            StringBuilder str = new StringBuilder();
            for(char c : st){
                str.append(c);
            }
            
            return str.toString();
    }
}