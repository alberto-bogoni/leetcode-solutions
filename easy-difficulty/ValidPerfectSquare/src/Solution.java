public class Solution {
    public boolean isPerfectSquare(int num) {
        return search(num, 0, num);
    }

    public boolean search(int n, int start, int end) {
        if (start > end) return false;

        int mid = start + (end - start) / 2;
        long square = (long) mid * mid;
        if (square == n) {
            return true;
        } else if (square > n) {
            return search(n, start, mid - 1);
        } else {
            return search(n, mid + 1, end);
        }
    }
}