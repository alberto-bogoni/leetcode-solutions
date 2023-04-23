/*
    Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means
     a backspace character.
*/

public class Solution {
    public boolean backSpaceCompare(String s, String t) {
        int endS = s.length() - 1;
        int endT = t.length() - 1;

        while (endT >= 0 && endS >= 0) {
            if (s.charAt(endS) == '#') {
                endS--;
                continue;
            }
            if (t.charAt(endT) == '#') {
                endT--;
                continue;
            }

            if(t.charAt(endT) != s.charAt(endS))
                return false;
            else {
                endT--;
                endS--;
            }
        }

        return true;
    }
}
