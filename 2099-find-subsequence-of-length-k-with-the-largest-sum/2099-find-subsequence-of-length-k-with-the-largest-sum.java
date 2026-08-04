class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        // Maintain the k largest elements in the min-heap
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }

        // Extract original indices of the k largest elements
        HashSet<Integer> targetIndices = new HashSet<>();
        while (!minHeap.isEmpty()) {
            targetIndices.add(minHeap.poll()[1]);
        }

        // Build the result array by traversing nums to preserve relative order
        int[] result = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (targetIndices.contains(i)) {
                result[index++] = nums[i];
            }
        }

        return result;
    }
}