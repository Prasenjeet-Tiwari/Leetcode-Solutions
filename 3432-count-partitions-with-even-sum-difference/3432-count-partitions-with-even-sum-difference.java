class Solution {
    public int countPartitions(int[] nums) {

        //prefix sum arrays
        int prfleft[]=new int[nums.length];
        int prfright[]=new int[nums.length];

        //from left to right
        prfleft[0]=nums[0]; 
        for(int i=1; i<nums.length; i++){
            prfleft[i]=nums[i]+prfleft[i-1];
        }

        //from right to left
        prfright[nums.length-1]=nums[nums.length-1]; 
        for(int i=nums.length -2; i>=0; i--){
            prfright[i]=nums[i]+prfright[i+1];
        }

        int output=0;
        for(int i=0; i<nums.length-1; i++){ //nums.length-1 cause cant use the last element
            if(Math.abs(prfleft[i]-prfright[i+1])%2==0){
                output++;
            }
        }
        return output;
    }
}