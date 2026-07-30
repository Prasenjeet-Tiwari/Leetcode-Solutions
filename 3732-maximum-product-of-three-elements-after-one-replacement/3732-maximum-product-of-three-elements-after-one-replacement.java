class Solution {
    public long maxProduct(int[] nums) {

        long third=100000;
        int n=nums.length;
        for(int i=0; i<n; i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        
        return third*nums[n-1]*nums[n-2];
        
    }
}