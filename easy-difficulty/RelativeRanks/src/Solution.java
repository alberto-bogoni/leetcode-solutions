import java.util.PriorityQueue;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        // 0 -> index
        // 1 -> score
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i1, i2) -> i2[1] - i1[1]);

        for (int i = 0; i < score.length; i++) {
            maxHeap.add(new int[]{i,score[i]});
        }

        String[] result = new String[score.length];

        int placement = 1;
        while (!maxHeap.isEmpty()) {
            int[] stat = maxHeap.poll();

            if (placement == 1) {
                result[stat[0]] = "Gold Medal";
            } else if (placement == 2) {
                result[stat[0]] = "Silver Medal";
            } else if (placement == 3) {
                result[stat[0]] = "Bronze Medal";
            } else {
                result[stat[0]] = String.valueOf(placement);
            }
            placement++;
        }

        return result;
    }
}