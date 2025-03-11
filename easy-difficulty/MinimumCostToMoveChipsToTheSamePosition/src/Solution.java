public class Solution {
    public int minCostToMoveChips(int[] position) {
        // 0 -> even, 1 -> odd
        int[] evenVsOdd = new int[2];
        for (Integer p : position) {
            if (p % 2 == 0)
                evenVsOdd[0]++;
            else
                evenVsOdd[1]++;
        }

        return Math.min(evenVsOdd[0], evenVsOdd[1]);
    }
}