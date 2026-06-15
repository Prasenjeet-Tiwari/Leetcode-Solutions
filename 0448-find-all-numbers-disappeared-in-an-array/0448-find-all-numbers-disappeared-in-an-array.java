class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int temp[]=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            temp[curr-1] =1;
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0; i<temp.length; i++){
            if(temp[i]!=1){
                list.add(i+1);
            }
        }

        return list;
    }
}