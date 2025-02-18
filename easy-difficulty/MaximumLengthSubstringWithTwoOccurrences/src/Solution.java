import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;

        Map<Character, Integer> frequencies = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            frequencies.put(s.charAt(right), frequencies.getOrDefault(s.charAt(right), 0) + 1);

            while (frequencies.get(s.charAt(right)) > 2) {
                frequencies.put(s.charAt(left), frequencies.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}