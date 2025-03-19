public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        return helper(piles, h, 1, max);
    }

    private int helper(int[] piles, int h, int left, int right) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int mid = left + (right - left) / 2;
        int hours = calculateHours(piles, mid);
        if (hours <= h) {
            int leftResult = helper(piles, h, left, mid - 1);
            return Math.min(mid, leftResult);
        } else {
            return helper(piles, h, mid + 1, right);
        }
    }

    private int calculateHours(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / speed);
        }
        return total;
    }
}