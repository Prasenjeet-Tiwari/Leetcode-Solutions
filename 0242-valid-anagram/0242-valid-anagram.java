class Solution {
    public boolean isAnagram(String s, String t) {
        int container[]= new int[26];
        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            int checkChar= s.charAt(i)-'a';
            container[checkChar] += 1;
        } 
        for(int i=0; i<t.length(); i++){
            int currChar=t.charAt(i) - 'a';
            if(container[currChar]==0){
                return false;
            }else{
                container[currChar] -= 1;
            }
        }

        return true;
        
    }
}