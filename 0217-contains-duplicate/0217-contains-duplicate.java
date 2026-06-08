class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs= new HashSet<>();

        for(int i=0; i< nums.length; i++){
            int curr= nums[i];
            if(hs.contains(curr)){
                return true;
            }
            hs.add(curr);
        }

        return false;
        
    }
}