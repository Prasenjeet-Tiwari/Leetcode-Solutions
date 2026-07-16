class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int curr=nums[0];
        for(int i=1;i<n; i++){
            if(curr==0){
                return false;
            }
            int val=nums[i];
            curr=Math.max(curr-1, val);
        }
        return true;
    }
}