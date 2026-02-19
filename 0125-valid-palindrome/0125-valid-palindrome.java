class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char curr=s.charAt(i);
            if(Character.isLetter(curr) || Character.isDigit(curr)){
                sb.append(Character.toLowerCase(curr));
            }
        }

        String str=sb.toString();

        if(str.length()==0 || str.length()==1) return true;

        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)==str.charAt( str.length()-i-1)){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }
}