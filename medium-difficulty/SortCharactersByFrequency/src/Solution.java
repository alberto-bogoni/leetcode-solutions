import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });
        maxHeap.addAll(freq.entrySet());

        StringBuilder result = new  StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();

            for (int i = 0; i < e.getValue(); i++) {
                result.append(e.getKey());
            }
        }

        return result.toString();
    }
}