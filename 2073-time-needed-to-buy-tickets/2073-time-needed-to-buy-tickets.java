class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int count=0;
        int idx=-1;
        int n=tickets.length;

        while(tickets[k] >=1){
            idx= (idx+1)%n;
            if(idx==k && tickets[idx]==1){
                count++;
                break;
            }else{
                if( tickets[idx] !=0){
                    count++;
                    tickets[idx]--;
                }
            }
        }
        return count;
        
    }
}