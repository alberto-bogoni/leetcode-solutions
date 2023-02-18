public class Solution {
    public boolean isPalindrome(int x) {
        Integer number = x;
        String string = number.toString();

        for (int i = 0, c = string.length() - 1; i < c; i++, c--) {
            if(!(string.charAt(i) == string.charAt(c)))
                return false;
        }

        return true;
    }
}
