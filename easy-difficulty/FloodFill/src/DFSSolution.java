/*
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the
     pixel image[sr][sc].

    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
    pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with
    the same color), and so on. Replace the color of all of the aforementioned pixels with color.

    Return the modified image after performing the flood fill.
 */

public class DFSSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        paint(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void paint (int[][] image, int i, int j, int startingPixel, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if (image[i][j] != startingPixel || image[i][j] == color) {
            return;
        }

        image[i][j] = color;
        paint(image, i + 1, j, startingPixel, color);
        paint(image, i - 1, j, startingPixel, color);
        paint(image, i, j + 1, startingPixel, color);
        paint(image, i, j - 1, startingPixel, color);
    }
}
