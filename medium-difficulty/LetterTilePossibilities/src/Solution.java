import java.util.HashMap;
import java.util.Map;

public class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        backtrack(map);
        return count;
    }

    public void backtrack(Map<Character, Integer> map) {

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 0) continue;
            count++;
            map.put(e.getKey(), e.getValue() - 1);
            backtrack(map);
            map.put(e.getKey(), e.getValue() + 1);
        }
    }
}