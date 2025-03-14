public class Solution {
    public int firstBadVersion(int n) {
        return search(1, n);
    }

    public int search(int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return search(start, mid - 1);
        } else {
            return search(mid + 1, end);
        }
    }

    private boolean isBadVersion(int n) {
        // This is implemented by using an interface in the leetcode platform. It's just a stub here.
       return true;
    }
}