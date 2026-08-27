class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs =new HashSet<>();
        for(int a: nums){
            hs.add(a);
        }
        for(int i=k; i<201; i+=k){
            if(!hs.contains(i)){
                return i;
            }
        }
        return -1;
        
    }
}