import java.util.HashSet;
import java.util.Set;

public class Solution {
    int max = 0;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        backtrack(s, 0, set);
        return max;
    }

    public void backtrack(String s, int start, Set<String> set) {
        if (start == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (set.contains(temp)) continue;
            set.add(temp);
            backtrack(s, i, set);
            set.remove(temp);
        }
    }
}