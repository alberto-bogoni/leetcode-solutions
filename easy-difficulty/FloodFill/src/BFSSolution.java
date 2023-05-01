import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int columns = image[0].length;

        Queue<int[]> neighbours = new LinkedList<>();
        neighbours.add(new int[]{ sr, sc });

        while (!neighbours.isEmpty()) {
            int row = neighbours.peek()[0];
            int column = neighbours.peek()[1];
            neighbours.remove();

            if (row < 0 || row >= rows || column < 0 || column >= columns) {
                continue;
            }
            if (image[row][column] != image[sr][sc] || image[row][column] == color) {
                continue;
            }

            image[row][column] = color;

            neighbours.add(new int[]{ row + 1, column });
            neighbours.add(new int[]{ row - 1, column });
            neighbours.add(new int[]{ row, column + 1 });
            neighbours.add(new int[]{ row, column - 1 });
        }

        return image;
    }
}
