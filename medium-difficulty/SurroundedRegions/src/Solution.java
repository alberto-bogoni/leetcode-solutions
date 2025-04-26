import java.util.List;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfsMark(board, i, 0);
            if (board[i][cols - 1] == 'O') dfsMark(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfsMark(board, 0, j);
            if (board[rows - 1][j] == 'O') dfsMark(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfsMark(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfsMark(board, i + 1, j);
        dfsMark(board, i - 1, j);
        dfsMark(board, i, j + 1);
        dfsMark(board, i, j - 1);
    }
}