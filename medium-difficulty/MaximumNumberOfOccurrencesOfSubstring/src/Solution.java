import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> substrFrequency = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (right - left + 1 > minSize) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            if (right - left + 1 == minSize && windowMap.size() <= maxLetters) {
                String substr = s.substring(left, right + 1);
                int count = substrFrequency.getOrDefault(substr, 0) + 1;
                substrFrequency.put(substr, count);
                max = Math.max(max, count);
            }
        }

        return max;
    }
}