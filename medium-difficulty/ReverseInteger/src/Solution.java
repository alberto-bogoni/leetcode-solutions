import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int reverse(int x) {
        Queue<Long> queue = new LinkedList<>();

        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            negative = true;
        }
        long dummy = (long) x;

        while (dummy > 0) {
            queue.add(dummy%10);
            dummy /= 10;
        }

        long result = 0;
        while (!queue.isEmpty())
            result = result * 10 + queue.poll();

        if (result > Integer.MAX_VALUE)
            return 0;
        return negative ? Math.negateExact((int)result) : (int)result;
    }

    public int reverseSecondApproach(int x) {

        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            negative = true;
        }
        long dummy = (long) x;
        long result = 0;

        while (dummy > 0) {
            result = 10 * result + dummy%10;
            dummy /= 10;

            if (result > Integer.MAX_VALUE)
                return 0;
        }

        return negative ? Math.negateExact((int)result) : (int)result;
    }
}