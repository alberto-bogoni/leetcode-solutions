import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        StringBuilder builder = new StringBuilder(s);
        for (int i = 0, c = s.length() - 1; c > i; ) {
            if (!vowels.contains(builder.charAt(c)))
                c--;
            if (!vowels.contains(builder.charAt(i)))
                i++;

            if (vowels.contains(builder.charAt(c)) && vowels.contains(builder.charAt(i))) {
                char temp = builder.charAt(c);
                builder.setCharAt(c--, builder.charAt(i));
                builder.setCharAt(i++, temp);
            }
        }

        return builder.toString();
    }
}
