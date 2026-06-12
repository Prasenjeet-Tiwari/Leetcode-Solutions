class Solution {

    class Trie {
        Trie[] child;

        Trie() {
            child = new Trie[2];
        }

        public void insert(int num) {
            Trie curr = this;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (curr.child[bit] == null) {
                    curr.child[bit] = new Trie();
                }

                curr = curr.child[bit];
            }
        }

        public int find(int num) {
            Trie curr = this;
            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit;

                if (curr.child[opposite] != null) {
                    maxXor |= (1 << i);
                    curr = curr.child[opposite];
                } else {
                    curr = curr.child[bit];
                }
            }

            return maxXor;
        }
    }

    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();

        for (int num : nums) {
            trie.insert(num);
        }

        int ans = 0;

        for (int num : nums) {
            ans = Math.max(ans, trie.find(num));
        }

        return ans;
    }
}