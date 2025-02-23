import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA == diffB) {
                return a - b;  
            }
            return diffA - diffB;
        });

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }

        result.sort((a,b) -> Integer.compare(a,b));

        return result;
    }
}