class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int[] arr = new int[nums.length];

        int evenIndex = 0; // even positions
        int oddIndex = 1;  // odd positions

        for (int num : nums) {
            if (num % 2 == 0) {
                arr[evenIndex] = num;
                evenIndex += 2;
            } else {
                arr[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return arr;
    }
}
