class Solution {
    public int maxProduct(int[] nums) {


        int n=nums.length;
        int currMax=nums[0];
        int currMin=nums[0];
        int max=nums[0];


        for(int i=1; i<n; i++){

            int temp= Math.max( currMax*nums[i], Math.max(nums[i], currMin*nums[i]));
            currMin= Math.min( currMax*nums[i],Math.min(nums[i], currMin*nums[i]));
            currMax=temp;
            max=Math.max(max, temp);
        }
        return max;
        
    }
}