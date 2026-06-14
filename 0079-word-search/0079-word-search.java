class Solution {

    public boolean dfs(int r, int c, int idx, char[][] board, String word) {

        if(idx == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx)){
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(r + 1, c, idx + 1, board, word) ||
                dfs(r - 1, c, idx + 1, board, word) ||
                dfs(r, c + 1, idx + 1, board, word) ||
                dfs(r, c - 1, idx + 1, board, word);

        board[r][c] = temp; // backtrack

        return found;
    }

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                if(dfs(i, j, 0, board, word))
                    return true;
            }
        }

        return false;
    }
}