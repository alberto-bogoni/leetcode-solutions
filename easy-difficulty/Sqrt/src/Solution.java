public class Solution {
    public int mySqrt(int x) {
        return search(x, 0, x);
    }

    public int search(int n, int start, int end) {
        if (start > end) return end;

        int mid = start + (end - start) / 2;
        long square = (long) mid * mid;
        if (square == n) {
            return mid;
        } else if (square > n) {
            return search(n, start, mid - 1);
        } else {
            return search(n, mid + 1, end);
        }
    }
}