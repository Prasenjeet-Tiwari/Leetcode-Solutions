class Solution {

    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1; // fix: last valid index

        while(low < high){
            
            int mid = low + (high - low) / 2;

            /*
             * If mid element is greater than next,
             * peak lies on left side (including mid)
             */
            if(nums[mid] > nums[mid + 1]){
                high = mid;
            } 
            else {
                /*
                 * If next element is greater,
                 * peak lies on right side
                 */
                low = mid + 1;
            }
        }

        // low == high → peak index
        return low;
    }
}