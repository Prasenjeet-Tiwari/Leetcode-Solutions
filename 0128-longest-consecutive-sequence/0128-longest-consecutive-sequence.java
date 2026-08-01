class Solution {
    //dsu

    
    // class dsu{
    //     int parent[];
    //     int size[];

    //     dsu(int n)}{
    //         parent=new parent[n];
    //         size=new parent[n];
    //         for (int i = 0; i < n; i++) {
    //             parent[i] = i;
    //             size[i] = 1;
    //         }
    //     }


    //     public int find(int i) {
    //         if (parent[i] == i) {
    //             return i;
    //         }
    //         return parent[i] = find(parent[i]); // Path compression
    //     }

    //     public void union(int a, int b) {
    //         int rootA = find(a);
    //         int rootB = find(b);
    //         if (rootA != rootB) {
    //             if (size[rootA] < size[rootB]) {
    //                 parent[rootA] = rootB;
    //                 size[rootB] += size[rootA];
    //             } else {
    //                 parent[rootB] = rootA;
    //                 size[rootA] += size[rootB];
    //             }
    //         }
    //     }
    // }
    public int longestConsecutive(int[] nums) {
        if(nums.length==0  ){
            return 0;
        }
        int longestStreak=1;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
           
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}