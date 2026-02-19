class Solution {
    public int countBinarySubstrings(String s) {

        if(s.length()==0 || s.length()==1) return 0;

        int curr=1,prv=0,res=0;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            }else{
                res += Math.min(prv,curr);
                prv=curr;
                curr=1;
            }
        }

         // final comparison( if last and second last are same then comparision wont take place so)
        res += Math.min(prv, curr);

        return res;
    }
}