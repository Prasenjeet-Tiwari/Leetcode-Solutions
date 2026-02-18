class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==1 || n==0) return true;

        String s=Integer.toBinaryString(n);
        char search=s.charAt(0);
        search=(search=='0'? '1':'0');
        
        for(int i=1; i<s.length(); i++){
            char curr= s.charAt(i);
            if(curr==search){
                search=(search=='0'? '1':'0');
            }else{
                return false;
            }
        }

        return true;
    }
}