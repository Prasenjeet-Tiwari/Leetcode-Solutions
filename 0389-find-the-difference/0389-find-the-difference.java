class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq=new int[26];

        for(char c: s.toCharArray()){
            int idx= c-'a';
            freq[idx]++;
        }
        for(char c: t.toCharArray()){
            int idx= c-'a';
            freq[idx]--;
        }
        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                return (char)(97+i);
            }
        }
        return 'a';
    }
}