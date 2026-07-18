class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public int findGCD(int[] nums) {
        int small=Integer.MAX_VALUE;
        int big=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            small= Math.min(small, nums[i]);
            big= Math.max(big, nums[i]);
        }
        return gcd(big, small);
    }
}