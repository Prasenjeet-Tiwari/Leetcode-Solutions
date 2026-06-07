class Solution {
    public boolean judgeCircle(String moves) {
        int i=0, j=0;
        for(int idx=0; idx<moves.length(); idx++){
            char c=moves.charAt(idx);
            if(c=='L'){
                i--;
            }else if(c=='R'){
                i++;
            }else if(c=='U'){
                j--;
            }else{
                j++;
            }
        }  
        if(i==0 && j==0){
            return true;
        }      
        return false;
    }
}