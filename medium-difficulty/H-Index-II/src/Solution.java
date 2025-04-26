public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        return bs(citations, 0, citations.length - 1);
    }

    public int bs(int[] cit, int start, int end) {
        if (start > end) return cit.length - start;

        int mid = start + (end - start) / 2;
        int n = cit.length;
        if (cit[mid] == n - mid) {
            return cit[mid];
        } else if (n - mid > cit[mid]) {
            return bs(cit, mid + 1, end);
        } else {
            return bs(cit, start, mid - 1);
        }
    }
}