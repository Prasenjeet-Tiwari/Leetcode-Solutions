class Solution {

    class Trie{
        Trie child[];
        boolean isEnd;

        Trie(){
            child= new Trie[26];
        }

        public void insert(String word){
            Trie curr= this;

            for(char c: word.toCharArray()){
                int idx= c-'a';
                if(curr.child[idx]==null){
                    curr.child[idx]=new Trie();
                }
                curr=curr.child[idx];
            }
            curr.isEnd=true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Trie trie=new Trie();

        for(int i=0; i<wordDict.size(); i++){
            String currStr= wordDict.get(i);
            trie.insert(currStr);
        }

        int n=s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;

        
        for(int i=0; i <n; i++){

            if(dp[i]==false) continue;
            
            //if true then search if isEnd true exist, if so then at which index

            Trie curr=trie;
            for(int j=i; j<n ; j++){
                int idx= s.charAt(j)-'a';
                if(curr.child[idx]==null){
                    break;
                }
                curr=curr.child[idx];
                if(curr.isEnd){
                    dp[j+1]=true; //means till j word exist you can start from j+1 to search new word
                }
            }
        }

        return dp[n];           
    }
}