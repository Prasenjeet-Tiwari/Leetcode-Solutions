class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        int count=0;
        for(String s : patterns){
            if(word.indexOf(s)>=0){
                count++;
            }
        }
        return count;
    }
}