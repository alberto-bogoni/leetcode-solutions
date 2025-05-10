import java.util.Stack;

class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int secondHalfStartIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            stack.push(c);
            if (c == ch) {
                secondHalfStartIndex = i + 1;
                break;
            }
        }
        if (secondHalfStartIndex == -1) return word;

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return secondHalfStartIndex <= word.length() - 1 ? sb.toString() + word.substring(secondHalfStartIndex, word.length()) : sb.toString();
    }
}