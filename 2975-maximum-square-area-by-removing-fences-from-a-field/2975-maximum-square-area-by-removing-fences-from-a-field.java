class Solution {

    
    static int mod = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        ArrayList<Integer> hl = new ArrayList<>();
        ArrayList<Integer> vl = new ArrayList<>();

        hl.add(1);
        hl.add(m);

        vl.add(1);
        vl.add(n);

        for (int x : hFences) {
            hl.add(x);
        }

        for (int x : vFences) {
            vl.add(x);
        }

        Collections.sort(hl);
        Collections.sort(vl);

        HashSet<Integer> horizontal = new HashSet<>();

        for (int i = 0; i < hl.size(); i++) {
            for (int j = i + 1; j < hl.size(); j++) {
                horizontal.add(hl.get(j) - hl.get(i));
            }
        }

        long side = -1;

        for (int i = 0; i < vl.size(); i++) {
            for (int j = i + 1; j < vl.size(); j++) {
                int diff = vl.get(j) - vl.get(i);

                if (horizontal.contains(diff)) {
                    side = Math.max(side, diff);
                }
            }
        }

        if (side == -1) {
            return -1;
        }

        return (int) ((side * side) % mod);
    }
}