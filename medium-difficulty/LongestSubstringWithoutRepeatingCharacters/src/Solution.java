import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int longest = 0;
        Set<Character> unique = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            while (left < right && unique.contains(c)) {
                unique.remove(s.charAt(left));
                left++;
            }

            unique.add(c);

            longest = Math.max(longest, (right - left) + 1);
        }

        return longest;
    }
}