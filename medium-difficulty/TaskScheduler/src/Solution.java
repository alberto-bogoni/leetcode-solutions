import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character t : tasks) map.put(t, map.getOrDefault(t, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        int intervals = 0;
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> wait = new LinkedList<>();
            int k = n + 1;

            for (; !maxHeap.isEmpty() && k > 0; k--) {
                Map.Entry<Character, Integer> e = maxHeap.poll();

                if (e.getValue() > 1) {
                    e.setValue(e.getValue() - 1);
                    wait.add(e);
                }

                intervals++;
            }
            maxHeap.addAll(wait);
            if (!maxHeap.isEmpty()) intervals += k;
        }

        return intervals;
    }
}