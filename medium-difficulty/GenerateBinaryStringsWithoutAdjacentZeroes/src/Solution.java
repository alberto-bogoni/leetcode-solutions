import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new LinkedList<>();
        backtrack(n, 0, new StringBuilder(), result);
        return result;
    }

    public void backtrack(int n, int start, StringBuilder sb,List<String> result) {
        if (sb.length() >= 2 && !sb.substring(start, sb.length()).contains("1")) return;
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        if (sb.length() >= 2) start++;

        backtrack(n, start, sb.append("0"), result);
        sb.deleteCharAt(sb.length() - 1);
        backtrack(n, start, sb.append("1"), result);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> validStringsSecond(int n) {
        List<String> result = new LinkedList<>();
        backtrack(n, new StringBuilder(), result);
        return result;
    }

    public void backtrack(int n, StringBuilder sb,List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        if(sb.isEmpty() || sb.charAt(sb.length() - 1) != '0') {
            backtrack(n, sb.append("0"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        backtrack(n, sb.append("1"), result);
        sb.deleteCharAt(sb.length() - 1);
    }
}