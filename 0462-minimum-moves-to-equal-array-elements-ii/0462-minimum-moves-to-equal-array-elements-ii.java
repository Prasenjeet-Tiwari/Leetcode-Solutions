class Solution {
    public int minMoves2(int[] nums) {

        int sum=0;
        int n=nums.length;
        
        Arrays.sort(nums);
        
        int median= n/2;
        int val=nums[median];

        for(int i=0; i<n; i++){
            sum+=Math.abs(nums[i]-val);
        }

        return sum;
    }
}