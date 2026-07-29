class Solution {
    public int longestSubarray(int[] A, int limit) {

        int i = 0;
        int j;
        int max=0;

        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (j = 0; j < A.length; j++) {

            m.put(A[j], 1 + m.getOrDefault(A[j], 0));

            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}