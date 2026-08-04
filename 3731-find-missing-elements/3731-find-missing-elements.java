class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int largest=0;
        int smallest=101;
        boolean vist[]=new boolean[101];

        for(int x: nums){
            if(x>largest){
                largest=x;
            }
            if(x<smallest){
                smallest=x;
            }
            vist[x]=true;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=smallest; i<=largest; i++){
            if(vist[i]==true) continue;
            list.add(i);
        }
        return list;
        
    }
}