import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        for (Map.Entry<Character,Integer> e : map.entrySet()) {
            maxHeap.add(e);
        }

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();

            if (previous != null && previous.getValue() > 0) {
                maxHeap.add(previous);
            }
            result.append(e.getKey());
            e.setValue(e.getValue()-1);
            previous = e;
        }

        String finalS = result.toString();
        return finalS.length() == s.length() ? finalS : "";
    }
}