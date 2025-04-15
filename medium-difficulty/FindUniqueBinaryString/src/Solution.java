import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String n : nums) {
            set.add(n);
        }

        return backtrack(set, "", nums[0].length());
    }

    public String backtrack(Set<String> set, String s, int length) {
        if (s.length() == length && !set.contains(s)) {
            return s;
        } else if (s.length() == length) return null;

        String zero = backtrack(set, s + "0", length);
        if (zero != null) return zero;
        String one = backtrack(set, s + "1", length);
        return one;
    }
}