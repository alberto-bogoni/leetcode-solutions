import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] parentheses = new char[n * 2];
        generate(0, 0, 0, parentheses, result, n);
        return result;
    }

    public void generate(int open, int closed,int index, char[] ps, List<String> result, int pairs) {

        if (open == pairs && closed == pairs) {
            result.add(new String(ps));
        } else {
            if (open > closed) {
                ps[index] = ')';
                generate(open, closed+1, index + 1, ps, result, pairs);
            }

            if (open < pairs) {
                ps[index] = '(';
                generate(open + 1, closed, index + 1, ps, result, pairs);
            }
        }
    }
}