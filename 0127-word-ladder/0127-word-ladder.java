import java.util.*;

class Solution { 
    public static class Pair { 
        String word; 
        int count; 
        
        Pair(String w, int c) { 
            this.word = w; 
            this.count = c; 
        } 
    } 

    public int ladderLength(String beginWord, String endWord, List<String> wordList) { 
        HashSet<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return 0; 
        }
        
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(beginWord, 1)); 
        set.remove(beginWord);
        
        int n = beginWord.length(); 
        
        while (!q.isEmpty()) { 
            Pair curr = q.poll(); 
            String currWord = curr.word; 
            int currCount = curr.count; 
            
            if (currWord.equals(endWord)) {
                return currCount;
            }
            
            for (int i = 0; i < n; i++) { 
                char[] replaced = currWord.toCharArray(); 
                
                for (char c = 'a'; c <= 'z'; c++) { 
                    replaced[i] = c;
                    String newWord = new String(replaced);
                    
                    if (set.contains(newWord)) {
                        q.offer(new Pair(newWord, currCount + 1));
                        set.remove(newWord); 
                    }
                } 
            } 
        } 
        
        return 0;
    } 
}
