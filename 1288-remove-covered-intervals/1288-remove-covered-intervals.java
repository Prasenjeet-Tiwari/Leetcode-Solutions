class Solution {
    public int removeCoveredIntervals(int[][] A) {
        Arrays.sort(A, (a, b) ->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });

        int res = 0, r = 0;

        for (int[] x : A) {
            if (x[1] > r) {
                r = x[1];
                res++;
            }
        }

        return res;
    }
}