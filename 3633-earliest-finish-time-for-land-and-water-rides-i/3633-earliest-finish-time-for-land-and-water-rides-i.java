class Solution {

    public int func(int[] firstRideStartTime, int[] firstRideDuration,int[] secondRideStartTime, int[] secondRideDuration,int ans) {

        for (int i = 0; i < firstRideStartTime.length; i++) {

            int firstFinish = firstRideStartTime[i] + firstRideDuration[i];

            for (int j = 0; j < secondRideStartTime.length; j++) {

                int secondStart = Math.max(firstFinish, secondRideStartTime[j]);
                int finishTime = secondStart + secondRideDuration[j];
                
                ans = Math.min(ans, finishTime);
            }
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = func(landStartTime, landDuration, waterStartTime, waterDuration, ans);

        ans = func(waterStartTime, waterDuration, landStartTime, landDuration, ans);

        return ans;
    }
}