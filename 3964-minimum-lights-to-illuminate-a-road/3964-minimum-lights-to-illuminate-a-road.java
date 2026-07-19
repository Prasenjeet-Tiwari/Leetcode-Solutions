class Solution {
    public int minLights(int[] lights) {

        int n = lights.length;

        int[] diffArray = new int[n + 1];

        //trying to fill as many as possible
        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int left = Math.max(0, i - lights[i]);
                int right = Math.min(n - 1, i + lights[i]);

                diffArray[left]++;
                if (right + 1 < n){ 
                     diffArray[right + 1]--;
                }
            }
        }

        int[] covered = new int[n];
        int currCover = 0;

        for (int i = 0; i < n; i++) {
            currCover += diffArray[i];
            covered[i] = currCover;
        }

        int totalLights = 0;

        for (int i = 0; i < n; ) {

            if (covered[i] > 0) {
                i++;
                continue;
            }

            totalLights++;

            i+=3;
        }

        return totalLights;
    }
}