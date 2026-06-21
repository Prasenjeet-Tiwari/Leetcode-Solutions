class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int maxCost = 0;
        for (int c : costs) {
            maxCost = Math.max(maxCost, c);
        }

        int[] freq= new int[maxCost+1];

        for(int x: costs){
            freq[x]++;
        }

        int count=0;

        int i=1;

        while(coins>=i && i<=maxCost){

            if(freq[i]!=0 ){
                count++;
                coins -= i;
                freq[i]= freq[i]-1;
            }else{
                i++;
            }
        }

        return count;

    }
}