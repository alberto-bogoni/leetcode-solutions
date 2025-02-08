import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;
        boolean oddFound = false;
        for (Integer v: map.values()) {
            if (v % 2 == 0)
                maxLength += v;
            else {
                maxLength += v - 1;
                oddFound = true;
            }
        }

        if (oddFound)
            maxLength++;

        return maxLength;
    }
    
}