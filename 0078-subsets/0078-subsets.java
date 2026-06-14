import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        // Sorting helps handle duplicates easily if you ever upgrade to Subsets II
        Arrays.sort(nums); 
        generateSubsets(0, nums, new ArrayList<>(), mainList);
        return mainList;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> mainList) {
        // Add a copy of the current subset to the result list
        mainList.add(new ArrayList<>(current));

        // Generate subsets by recursively including subsequent elements
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // Include the element
            generateSubsets(i + 1, nums, current, mainList); // Recurse
            current.remove(current.size() - 1); // Backtrack (Exclude the element)
        }
    }
}
