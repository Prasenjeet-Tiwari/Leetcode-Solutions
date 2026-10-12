class Solution {
    public int maxSum(List<Integer> nums, int k) {

        int mod=1_000_000_007;
        
        int bits[]=new int[32];

        for(int curr : nums){

            for(int i=0; i<32; i++){
                if(((curr>>i)&1)==1){
                    bits[i]++;
                }
            }
        }

        long ans=0;

        for(int count=0; count<k; count++){
            long nowVal=0;
            for(int i=0; i<32; i++){
                if(bits[i]>=1){
                    nowVal= nowVal | (1L<<i);
                    bits[i]--;
                }
            }
            ans=  (ans +(nowVal*nowVal)%mod ) % mod;
        }
        return (int)ans;
    }
}