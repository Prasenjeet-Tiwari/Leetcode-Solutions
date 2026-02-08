class Solution {

    

    public int finalElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        
        return Math.max(nums[i],nums[j]);
    }
}
