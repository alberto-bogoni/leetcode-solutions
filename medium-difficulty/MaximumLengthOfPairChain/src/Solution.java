import java.util.Arrays;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int longest = 0;

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1],b[1]));

        int end = pairs[0][1];
        int count = 1;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }

        return count;
    }
}