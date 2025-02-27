public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word, new boolean[board.length][board[0].length]))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (index > word.length() || word.charAt(index) != board[i][j] || visited[i][j])
            return false;
        if (index == word.length()-1)
            return true;

        visited[i][j] = true;

        boolean result = dfs(board, i + 1, j, index + 1, word, visited) ||
                dfs(board, i - 1, j, index + 1, word, visited) ||
                dfs(board, i, j + 1, index + 1, word, visited) ||
                dfs(board, i, j - 1, index + 1, word, visited);

        visited[i][j] = false;

        return result;
    }
}