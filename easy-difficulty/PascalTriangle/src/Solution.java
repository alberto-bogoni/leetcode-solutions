import java.util.*;

/*
  Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleLevels = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            int capacity = i + 1;
            ArrayList<Integer> level = new ArrayList<>(capacity);

            level.add(1);
            for (int c = 1; c < capacity - 1; c++) {
                if (capacity != 2)
                    level.add(triangleLevels.get(i - 1).get(c - 1) + triangleLevels.get(i - 1).get(c));
            }
            if (capacity != 1)
                level.add(1);

            triangleLevels.add(i, level);
        }

        return triangleLevels;
    }
}
