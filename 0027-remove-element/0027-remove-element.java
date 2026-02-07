class Solution {
    public int removeElement(int[] nums, int val) {
        int arr[]=new int[nums.length];
        int j=0;
        for(int i=0; i <nums.length; i++){
            if(nums[i]!=val){
                arr[j++]=nums[i];
            }
        }

        //updating nums arr
        for(int k=0; k<j; k++){ //why update all, just as much as required(eat 5 star do nothing)
            nums[k]=arr[k];
        }
        return j;
    }
}