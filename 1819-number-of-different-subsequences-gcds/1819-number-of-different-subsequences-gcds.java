class Solution {
    public int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int maxVal=0;
        for(int x: nums){
             maxVal = Math.max(maxVal, x);
        }
        boolean present[]=new boolean[maxVal+1];
        for(int x: nums){
            present[x]=true;
        }

        int ans=0;
        for(int i=1; i<=maxVal; i++){
            int curr=0;
            for(int j=i; j<=maxVal; j+=i){
                if(present[j]){
                    curr=gcd(curr,j);
                    if (curr == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
        

    }
}