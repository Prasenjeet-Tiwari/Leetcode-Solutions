class Solution {
        
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for (int i = n - 2; i > -1; i--)
            if (nums[i] < nums[i + 1]) {        // BREAK POINT
                idx = i;
                break;
            }
        if (idx == -1) {                        // IF NO BREAK POINT ITS THE LAST PERMUTATION NOW WE REVERSE TO SORTED ORDER
            rev(nums, 0, n - 1);
            return;
        }
        for (int i = n -1; i > idx; i--)        // SWAPING THE BREAK POINT WITH MIN NEXT NUM 
            if (nums[i] > nums[idx]) {
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
                break;
            }
        rev(nums, idx + 1, n - 1);              // REV FROM BREAK POINT TO END
        
    }
    public void rev(int[] nums, int l, int r) {
        while (r > l) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l ++;
            r --;
        }
    }
}