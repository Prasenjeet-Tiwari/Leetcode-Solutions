import java.util.HashMap;
import java.util.Map;

class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Path compression
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] < size[rootB]) {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                } else {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                }
            }
        }
        
        public int getMaxSize() {
            int max = 0;
            for (int s : size) {
                max = Math.max(max, s);
            }
            return max;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        DSU dsu = new DSU(nums.length);
        // Map to store value -> index mapping to handle duplicates and track array positions
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue; // Skip duplicates to avoid self-unions or corrupted tracking
            }
            
            map.put(nums[i], i);

            // Connect with the smaller consecutive neighbor if it exists
            if (map.containsKey(nums[i] - 1)) {
                dsu.union(i, map.get(nums[i] - 1));
            }
            
            // Connect with the larger consecutive neighbor if it exists
            if (map.containsKey(nums[i] + 1)) {
                dsu.union(i, map.get(nums[i] + 1));
            }
        }

        return dsu.getMaxSize();
    }
}
