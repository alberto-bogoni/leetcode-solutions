import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        if (s.isEmpty())
            return 0;

        int min = 0;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    min++;
                else
                    stack.pop();
            }
        }
        if (!stack.isEmpty())
            min += stack.size();

        return min;
    }
}