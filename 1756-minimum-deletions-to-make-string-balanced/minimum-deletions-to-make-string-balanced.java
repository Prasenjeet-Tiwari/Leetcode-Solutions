class Solution {
    public int minimumDeletions(String s) {
        
        int counta[]=new int[s.length()];
        int countb[]=new int[s.length()];

        //count of no of 'a' on the left of partition line
        int found_b=0;
        for(int i=0; i<s.length(); i++){
            
            countb[i]=found_b;
            if(s.charAt(i)=='b'){ 
                found_b++;
            }
        }


        //count of no of 'a' on the left of partition line
        int found_a=0;
        for(int i=s.length()-1; i>=0; i--){
            counta[i]=found_a;
            if(s.charAt(i)=='a'){ 
                found_a++;
            }
        }

        int min=Integer.MAX_VALUE;

        //so thr no of 'a' on left to delet + no of 'b' to delete on right side
        //the current position doesn't matter cause its point or the point after which elemnt chaneg
        
        for(int i=0; i<s.length(); i++){
            min=Math.min(min,counta[i]+countb[i]);
        }

        return min;
    }
}