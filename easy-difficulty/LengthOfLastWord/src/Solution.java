import java.util.Arrays;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        String[] stringWithoutSpaces = s.split(" ");
        int index = stringWithoutSpaces.length - 1;

        return stringWithoutSpaces[index].length();
    }
}
