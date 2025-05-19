import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : words) freq.put(s, freq.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.getValue() == a.getValue()) return a.getKey().compareTo(b.getKey());
            return b.getValue() - a.getValue();
        });
        maxHeap.addAll(freq.entrySet());

        int count = 0;
        List<String> result = new LinkedList<>();
        while (!maxHeap.isEmpty() && count < k) {
            result.add(maxHeap.poll().getKey());
            count++;
        }
        return result;
    }
}