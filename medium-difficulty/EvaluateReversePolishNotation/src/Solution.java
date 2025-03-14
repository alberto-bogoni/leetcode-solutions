import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int total = 0;
        for (String s : tokens) {
            if (s.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = n1 + n2;
                stack.push(result);
            } else if (s.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = n2 - n1;
                stack.push(result);
            } else if (s.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = n2 / n1;
                stack.push(result);
            } else if (s.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = n1 * n2;
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.peek();
    }
}