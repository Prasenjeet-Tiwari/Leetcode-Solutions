class Solution {
    public int majorityElement(int[] nums) {

        int element_value= nums[0];
        int element_freq=1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]==element_value){
                element_freq+=1;
            }else{
                element_freq-=1;
            }

            if(element_freq==0){
                element_freq=1;
                element_value=nums[i];
            }
        }


        return element_value;
        
    }
}