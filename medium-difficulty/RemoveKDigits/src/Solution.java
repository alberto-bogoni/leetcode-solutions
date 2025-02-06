import java.util.Stack;

public class Solution {
    
    public String removeKdigits(String num, int k) {
        if (num.length() == 1)
            return "0";

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            Character n = num.charAt(i);

            while (
                    !stack.isEmpty() &&
                            Character.getNumericValue(stack.peek()) > Character.getNumericValue(n) &&
                            count < k
            ) {

                stack.pop();
                count++;
            }
            if (stack.isEmpty() && n == '0')
                continue;

            stack.push(n);
        }

        while (!stack.isEmpty() && count < k) {
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.insert(0, stack.pop());
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}