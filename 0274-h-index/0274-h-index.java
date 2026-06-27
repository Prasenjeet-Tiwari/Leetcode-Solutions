class Solution {
    public int hIndex(int[] citations) {
        
        int output[]=new int[citations.length];

        for(int i=0; i<citations.length; i++){
            int count=0;
            for(int y: citations){
                if(y>=i+1){
                    count++;
                }
            }
            output[i]=count;
            System.out.println( i+1+" : "+output[i]);
        }
        int ans=0;
        for(int i=0; i<output.length; i++){
            if(i+1<=output[i]){
                ans=i+1;
            }else{
                break;
            }
        }
        return ans;
    }
}