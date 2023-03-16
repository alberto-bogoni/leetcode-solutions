public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int is = 0;
        int ie = s.length() - 1;

        while (is < ie) {
            if (!(Character.isDigit(s.charAt(is)) || Character.isLetter(s.charAt(is)))) {
                is++;
                continue;
            }
            if (!(Character.isDigit(s.charAt(ie)) || Character.isLetter(s.charAt(ie)))) {
                ie--;
                continue;
            }

            if (!(Character.toLowerCase(s.charAt(is++)) == Character.toLowerCase(s.charAt(ie--))))
                return false;
        }

        return true;
    }
}
