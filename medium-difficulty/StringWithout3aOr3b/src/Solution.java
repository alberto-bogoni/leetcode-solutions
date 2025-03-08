public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > 0 || b > 0) {
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                char last = sb.charAt(sb.length()-1);
                if (last == 'a') {
                    sb.append('b');
                    b--;
                } else {
                    sb.append('a');
                    a--;
                }
            } else if (a > 0 && a >= b) {
                sb.append('a');
                a--;
            } else if (b > 0) {
                sb.append('b');
                b--;
            }
        }

        return sb.toString();
    }
}