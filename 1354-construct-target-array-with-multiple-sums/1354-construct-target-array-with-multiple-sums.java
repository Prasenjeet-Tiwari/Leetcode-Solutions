import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] target) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        long total = 0;

        for (int num : target) {
            total += num;
            maxHeap.offer(num);
        }

        while (true) {

            int max = maxHeap.poll();
            long rest = total - max;

            if (max == 1 || rest == 1) {
                return true;
            }

            if (rest == 0 || max < rest || max % rest == 0) {
                return false;
            }

            int prev = (int)(max % rest);

            total = rest + prev;
            maxHeap.offer(prev);
        }
    }
}