import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> pairs = new ArrayList<>(position.length);
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            int[] pair = new int[2];
            pair[0] = position[i];
            pair[1] = speed[i];
            pairs.add(pair);
        }

        Collections.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < pairs.size(); i++) {
            int[] pair = pairs.get(i);
            double time = (target - pair[0]) / (double)pair[1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}