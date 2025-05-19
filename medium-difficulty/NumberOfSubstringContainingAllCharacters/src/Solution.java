import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() == 3) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                result += s.length() - right;
                left++;
            }
        }
        return result;
    }
}