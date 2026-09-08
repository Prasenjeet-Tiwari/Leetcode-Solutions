class Solution {
    public int countCommas(int n) {
        int temp=n;
        int count=0;
        while(temp>0){
            temp/=10;
            count++;
        }
        if(count<=3){
            return 0;
        }else {
            return n-1000+1;
        }
        
    }
}