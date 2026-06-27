import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //  Min-Heap (Priority Queue) based on frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        //Maintain only the top K frequent elements in the heap
        for (int num : freqMap.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
