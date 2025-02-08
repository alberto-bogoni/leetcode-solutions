import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c: text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minInstances = Integer.MAX_VALUE;
        minInstances = Math.min(minInstances, map.getOrDefault('b', 0));
        minInstances = Math.min(minInstances, map.getOrDefault('a', 0));
        minInstances = Math.min(minInstances, map.getOrDefault('l', 0) / 2);
        minInstances = Math.min(minInstances, map.getOrDefault('o', 0) / 2);
        minInstances = Math.min(minInstances, map.getOrDefault('n', 0));

        return minInstances;
    }

    public int maxNumberOfBalloonsSecondApproach(String text) {
        int[] chars = new int[26];

        for (Character c: text.toCharArray()) {
            chars[c - 'a']++;
        }

        int minInstances = Integer.MAX_VALUE;
        minInstances = Math.min(minInstances, chars['b' - 'a']);
        minInstances = Math.min(minInstances, chars[0]);
        minInstances = Math.min(minInstances, chars['l' - 'a'] / 2);
        minInstances = Math.min(minInstances, chars['o' - 'a'] / 2);
        minInstances = Math.min(minInstances, chars['n' - 'a']);

        return minInstances;
    }
}