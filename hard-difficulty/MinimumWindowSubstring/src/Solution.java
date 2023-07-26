import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
       String minSubstring = "";

       Map<Character, Integer> charFrequency = new HashMap<>();
       for (char c: t.toCharArray()) {
          charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
       }

       int windowStart = 0;
       int matched = 0;

       for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
          char rightChar = s.charAt(windowEnd);
          if (charFrequency.containsKey(rightChar)) {
              charFrequency.put(rightChar, charFrequency.get(rightChar) - 1);
              if (charFrequency.get(rightChar) >= 0)
                  matched++;
          }

          while (matched == t.length()) {
              String substring = s.substring(windowStart, windowEnd + 1);
              if (substring.length() < minSubstring.length() || minSubstring.isBlank())
                  minSubstring = substring;

              char leftChar = s.charAt(windowStart++);
              if (charFrequency.containsKey(leftChar)) {
                  if (charFrequency.get(leftChar) == 0)
                    matched--;
                  charFrequency.put(leftChar, charFrequency.get(leftChar) + 1);
              }
          }
       }

       return minSubstring;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
