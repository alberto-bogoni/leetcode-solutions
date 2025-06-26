import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String original = s;
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, l -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}