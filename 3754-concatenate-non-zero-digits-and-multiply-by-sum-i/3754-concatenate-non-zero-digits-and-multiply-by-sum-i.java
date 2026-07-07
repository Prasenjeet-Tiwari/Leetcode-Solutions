class Solution {
    public long sumAndMultiply(int n) {

        if(n==0){
            return 0;
        }

        long sum=0;
        StringBuilder sb=new StringBuilder();

        while(n>0){
            int rem=n%10;
            n/=10;
            sum+=rem;
            if(rem!=0){
                sb.append(Integer.toString(rem));
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        long x=Long.parseLong(sb.reverse().toString())*sum;
        return x;
        
    }
}