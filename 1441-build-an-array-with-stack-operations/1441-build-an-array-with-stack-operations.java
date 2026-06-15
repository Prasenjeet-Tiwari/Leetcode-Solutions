class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> list= new ArrayList<>();

        int idx=0;

        for(int i=1; i<=n; i++){
            int curr=i;
            if(idx==target.length){
                break;
            }
            if(target[idx]==curr){
                list.add("Push");
                idx++;
            }else{
                list.add("Push");
                list.add("Pop");
            }

        }
        return list;
    }
}