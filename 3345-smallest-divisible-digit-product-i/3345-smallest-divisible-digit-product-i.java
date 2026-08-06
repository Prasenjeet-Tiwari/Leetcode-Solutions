class Solution {
    public int smallestNumber(int n, int t) {

        while(true){
            int val=n;
            int curr=1;
            while(val>0){
                int x=val%10;
                curr*= x;
                val/=10;
            }
            if(curr%t==0){
                return n;
            }
            n=n+1;
        }
        
    }
}