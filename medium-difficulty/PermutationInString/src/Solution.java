import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int matched = 0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : s1.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
            char rightChar = s2.charAt(windowEnd);

            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= s1.length() - 1) {
                char leftChar = s2.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--;
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }
}
