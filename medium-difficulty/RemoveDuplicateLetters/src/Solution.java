import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashSet<Character> present = new HashSet<>();
        Stack<Character> result = new Stack<>();

        // Counting the frequency of each character
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (!present.contains(c)) {
                while (!result.isEmpty() && c < result.peek() && count.get(result.peek()) > 0) {
                    present.remove(result.pop());
                }
                result.push(c);
                present.add(c);
            }
            count.put(c, count.get(c) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }
}