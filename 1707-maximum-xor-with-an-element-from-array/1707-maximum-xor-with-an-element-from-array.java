import java.util.*;

class Solution {

    class Trie {
        Trie[] child;

        Trie() {
            child = new Trie[2];
        }

        public void insert(int val) {
            Trie curr = this;

            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;

                if (curr.child[bit] == null) {
                    curr.child[bit] = new Trie();
                }

                curr = curr.child[bit];
            }
        }

        public int maxXOR(int val) {
            Trie curr = this;
            int max = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;
                int opposite = 1 - bit;

                if (curr.child[opposite] != null) {
                    max |= (1 << i);
                    curr = curr.child[opposite];
                } else {
                    curr = curr.child[bit];
                }
            }

            return max;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        int n = queries.length;

        int[][] temp = new int[n][3];

        for (int i = 0; i < n; i++) {
            temp[i][0] = queries[i][0]; // xi
            temp[i][1] = queries[i][1]; // mi
            temp[i][2] = i;             // original index
        }

        Arrays.sort(temp, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(nums);

        Trie trie = new Trie();

        int[] ans = new int[n];
        int ptr = 0;

        for (int i = 0; i < n; i++) {

            int x = temp[i][0];
            int m = temp[i][1];
            int idx = temp[i][2];

            while (ptr < nums.length && nums[ptr] <= m) {
                trie.insert(nums[ptr]);
                ptr++;
            }

            if (ptr == 0) {
                ans[idx] = -1;
            } else {
                ans[idx] = trie.maxXOR(x);
            }
        }

        return ans;
    }
}