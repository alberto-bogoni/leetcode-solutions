import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            Character c = order.charAt(i);
            if (map.containsKey(c)) {
                while (map.get(c) != 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        for (Map.Entry<Character,Integer> e: map.entrySet()) {
            while (e.getValue() != 0) {
                sb.append(e.getKey());
                map.put(e.getKey(), e.getValue() - 1);
            }
        }

        return sb.toString();
    }
}