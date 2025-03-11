public class Solution {
    public String largestPalindromic(String num) {
        StringBuilder firstHalf = new StringBuilder();
        int[] frequency = new int[10];

        for (int i = 0; i < num.length(); i++) {
            int val = (num.charAt(i) - '0');
            frequency[val] += 1;
        }

        int middle = -1;

        for (int i = 9; i >= 0; i--) {
            if (frequency[i] != 0 && (i != 0 || firstHalf.length() > 0)) {
                int count = frequency[i];
                while (count > 1) {
                    firstHalf.append(i);
                    count -= 2;
                }
                if (count == 1 && middle == -1) {
                    middle = i;
                }
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf);
        if (middle != -1) firstHalf.append(middle);
        firstHalf.append(secondHalf.reverse());

        return firstHalf.length() > 0 ? firstHalf.toString() : "0";
    }
}