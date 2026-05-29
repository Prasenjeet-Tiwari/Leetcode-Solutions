class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> tm= new TreeMap<>();

        for(int i=0; i<hand.length; i++){
            int elem= hand[i];
            tm.put(elem , tm.getOrDefault(elem,0)+1 );
        }

        while( !tm.isEmpty()){

            int curr_elem= tm.firstKey();

            for(int i=0; i<groupSize; i++){

                int req_elem= curr_elem + i;
                if( !tm.containsKey(req_elem)){
                    return false;
                }
                tm.put( req_elem, tm.get(req_elem)-1 );
                if( tm.get(req_elem) == 0){
                    tm.remove( req_elem);
                }
            }
        }

        return true;

        
    }
}