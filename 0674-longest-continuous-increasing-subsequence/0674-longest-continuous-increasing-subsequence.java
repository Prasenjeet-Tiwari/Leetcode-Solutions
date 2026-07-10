class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count=1;
        int n=nums.length;
        int max=1;

        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                max=Math.max(count,max);
                count=1;
            }
        }
        max=Math.max(count,max);
        return max;
    }
}