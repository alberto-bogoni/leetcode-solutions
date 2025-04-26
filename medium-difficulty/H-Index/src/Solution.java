import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        return bs(citations, 0, citations.length - 1);
    }

    public int bs(int[] cit, int start, int end) {
        if (start > end) return cit.length - start;

        int mid = start + (end - start) / 2;
        if (cit[mid] == cit.length - mid) {
            return cit[mid];
        } else if (cit[mid] > cit.length - mid) {
            return bs(cit, start, mid - 1);
        } else {
            return bs(cit, mid + 1, end);
        }
    }
}