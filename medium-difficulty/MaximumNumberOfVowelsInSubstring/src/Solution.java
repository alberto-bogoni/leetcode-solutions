import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>() {{
            add('a');add('e');add('i');add('o');add('u');
        }};
        int max = Integer.MIN_VALUE;

        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if ((right - left + 1) > k) {
                if (set.contains(s.charAt(left)))
                    count--;
                left++;
            }

            if (set.contains(s.charAt(right))) {
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}