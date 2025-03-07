import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            Integer frequencyA = map.get(a);
            Integer frequencyB = map.get(b);

            if (frequencyA.equals(frequencyB)) return b - a;
            return frequencyA - frequencyB;
        });

        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer n : nums) {
            queue.add(n);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}