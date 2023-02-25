import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            int number = factorial(rowIndex)/(factorial(i)*factorial(rowIndex - i));
            row.add(number);
        }

        return row;
    }

    int factorial(int n) {
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }
}
