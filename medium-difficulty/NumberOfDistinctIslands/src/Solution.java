import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int findDistinctIslandsDFS(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int numberOfDistinctIslands = 0;
        Set<String> islandExplorationPaths = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                   if (islandExplorationPaths.add(visitIsland(matrix, i, j, new StringBuilder(), ""))) {
                       numberOfDistinctIslands++;
                   }
                }
            }
        }

        return numberOfDistinctIslands;
    }

    private static String visitIsland(int[][] matrix, int i, int j, StringBuilder builder, String s) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return "";
        }
        if (matrix[i][j] == 0 || matrix[i][j] == -1)
            return "";

        matrix[i][j] = -1;

        builder.append(s);
        builder.append(visitIsland(matrix, i + 1, j, builder, "D"));
        builder.append(visitIsland(matrix, i - 1, j, builder, "U"));
        builder.append(visitIsland(matrix, i, j + 1, builder, "R"));
        builder.append(visitIsland(matrix, i, j - 1, builder, "L"));
        return builder.toString();
    }
}
