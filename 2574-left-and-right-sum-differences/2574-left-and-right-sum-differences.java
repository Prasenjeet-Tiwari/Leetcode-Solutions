class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];

        for(int i=1; i<nums.length; i++){
            left[i]= nums[i-1]+left[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            right[i]= nums[i+1] + right[i+1];
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=Math.abs(left[i]-right[i]);
        }

        return nums;
        
    }
}