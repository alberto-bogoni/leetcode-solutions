//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

public class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (evenDigits(nums[i]))
                counter++;
        }

        return counter;
    }

    public boolean evenDigits(int number) {
        return countDigits(number) % 2 == 0;
    }

    public int countDigits(int number) {
        if (number == 0) return 1;

        return (int) (Math.log10(Math.abs(number)) + 1);
    }
}
