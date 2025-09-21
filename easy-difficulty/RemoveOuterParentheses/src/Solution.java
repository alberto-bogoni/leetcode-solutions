public class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;

        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                close++;
            }

            if (open > 0 && open == close) {
                String sub = s.substring(start + 1, i);
                sb.append(sub);
                open = 0;
                close = 0;
                start = i + 1;
                continue;
            }
        }

        return sb.toString();
    }
}