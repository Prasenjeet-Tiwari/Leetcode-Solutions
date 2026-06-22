class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] freq=new int[5];
        //if a-> 0 ;  if b-> 1; if l->2;  if o->3; if n->4

        for(char c: text.toCharArray()){
            if(c=='a'){
                freq[0]++;
                
            }else if(c=='b'){
                freq[1]++;
                
            }else if(c=='l'){
                freq[2]++;
                
            }else if(c=='o'){
                freq[3]++;
                
            }else if(c=='n'){
                freq[4]++;
            }
        }
        freq[2] /=2; freq[3]/=2;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<freq.length; i++){
            min=Math.min(min, freq[i]);
        }

        return min;
        
    }
}