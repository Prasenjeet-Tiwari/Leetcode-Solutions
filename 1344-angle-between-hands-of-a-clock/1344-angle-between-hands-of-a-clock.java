class Solution {
    public double angleClock(int hour, int minutes) {

        //60 min -> 360 degree
        //1min   -> 6 degree

        //12 hrs ->360deg  so  1hr-> 30deg 

        //extra degree== 
        // 60min(1hr) -> 30degree
        //  1min -> 0.5 degree

        double degMin= minutes *6.0; //lets take 12 as start point so 0:00
        double degHour= ( hour % 12) * 30.0; 
        degHour += (minutes* 0.5);

        double diff= Math.abs(degHour - degMin);

        return Math.min( diff, 360.0-diff);
        
    }
}