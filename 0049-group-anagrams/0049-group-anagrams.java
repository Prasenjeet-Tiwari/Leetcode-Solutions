class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, Integer> hm= new HashMap<>();
        List<List<String>> list= new ArrayList<>();
        int idxList=-1;

        for(int i=0; i<strs.length; i++){

            String curr= strs[i];

            char arr[]= curr.toCharArray();
            Arrays.sort(arr);
            String sorted= new String(arr);

            if(hm.containsKey(sorted)){
                int key=hm.get(sorted);
                list.get(key).add(curr);
            }else{
                idxList = idxList+1;
                hm.put(sorted, idxList);
                list.add(new ArrayList<>());
                list.get(idxList).add(curr);
            }
        }

        return list;
        
    }
}