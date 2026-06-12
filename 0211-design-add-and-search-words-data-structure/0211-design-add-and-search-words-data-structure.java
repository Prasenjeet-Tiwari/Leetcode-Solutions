class WordDictionary {

    class Trie {
        Trie[] child = new Trie[26];
        boolean isEnd;
    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;

        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if(curr.child[idx] == null)
                curr.child[idx] = new Trie();

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int pos, String word, Trie node) {

        if(node == null)
            return false;

        if(pos == word.length())
            return node.isEnd;

        char ch = word.charAt(pos);

        if(ch == '.') {

            for(int i = 0; i < 26; i++) {
                if(dfs(pos + 1, word, node.child[i]))
                    return true;
            }

            return false;
        }

        return dfs(pos + 1, word,
                   node.child[ch - 'a']);
    }
}