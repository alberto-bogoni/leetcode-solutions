import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[board.length];
        HashSet<Integer>[] cols = new HashSet[board[0].length];
        HashSet<Integer>[] boxes = new HashSet[board.length];

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;

                int val = board[i][j];

                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(val) || cols[j].contains(val) || boxes[boxIndex].contains(val)) return false;

                rows[i].add(val);
                cols[j].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}