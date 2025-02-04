import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> openBrackets = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('{', '}');
        brackets.put('[', ']');
        brackets.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            Character bracket = s.charAt(i);
            if (brackets.containsKey(bracket))
                openBrackets.push(bracket);
            else if (openBrackets.isEmpty()) {
                return false;
            } else {
                Character lastOpenBracket = openBrackets.pop();
                if (!brackets.get(lastOpenBracket).equals(bracket)) {
                    return false;
                }
            }
        }

        return openBrackets.isEmpty();
    }

}