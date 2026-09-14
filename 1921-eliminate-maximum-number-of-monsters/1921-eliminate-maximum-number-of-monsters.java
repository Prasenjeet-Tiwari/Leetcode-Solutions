import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] arrivalTimes = new double[n];
        
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (double) dist[i] / speed[i];
        }
        
        Arrays.sort(arrivalTimes);
        
        int count = 0;
        for (int p = 0; p < n; p++) {
            if (arrivalTimes[p] <= p) {
                break;
            }
            count++;
        }
        
        return count;
    }
}
