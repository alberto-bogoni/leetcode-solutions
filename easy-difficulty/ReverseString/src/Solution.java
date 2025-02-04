import java.util.Stack;

public class Solution {

    public void reverseString(char[] s) {
        Stack<Character> reversed = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            reversed.push(s[i]);
        }

        for (int i = 0; i < s.length; i++) {
            Character c = reversed.pop();
            s[i] = c;
        }
    }
    
}