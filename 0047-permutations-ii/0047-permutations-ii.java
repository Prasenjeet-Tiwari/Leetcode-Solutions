class Solution {
    public void recursion (List<List<Integer>> list, List<Integer> curr, int[] nums, boolean[] used){
        if(curr.size()==nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // Skip elements that are already in our current permutation
            if (used[i]) continue;
            
            used[i] = true;
            curr.add(nums[i]);
            
            recursion(list, curr, nums, used); // Explore further
            
            // Backtrack
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr= new ArrayList<>();

        recursion(list, curr, nums, new boolean[nums.length]);
        HashMap<List<Integer>, Integer> hm=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();

        for(List<Integer> n : list){
            if(!hm.containsKey(n)){
                ans.add(n);
            }
            hm.put(n,1);
        }

        return ans;
        
    }
}