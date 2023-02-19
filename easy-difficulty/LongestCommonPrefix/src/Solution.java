import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        Arrays.sort(strs);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                builder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return builder.toString();
    }
}
