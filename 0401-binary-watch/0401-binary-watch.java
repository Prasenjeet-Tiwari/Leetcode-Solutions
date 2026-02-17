class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans= new ArrayList<>();

        for(int i=0; i<12; i++){    //12 not included
            for(int j=0; j<=59; j++){   //59 included
                int count=Integer.bitCount(i)+Integer.bitCount(j);
                if(count==turnedOn){
                    String output=i+":"+String.format("%02d",j);
                    ans.add(output);
                }
            }
        }

        return ans;
    }
}