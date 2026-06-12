class Solution {
    public int maximumStrongPairXor(int[] nums) {
        
        int n=nums.length;

        int output=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int val=Math.abs(nums[i]-nums[j]);
                int min= Math.min(nums[i],nums[j]);

                if(val<=min){
                    output=Math.max(output, (nums[i]^nums[j]));
                }
            }
        }

        return output;
        
    }
}