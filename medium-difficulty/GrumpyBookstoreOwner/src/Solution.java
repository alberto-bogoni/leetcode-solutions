public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int maxAdditionalSatisfaction = 0;
        int currentWindowSatisfaction = 0;
        int left = 0;

        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right] == 0) {
                totalSatisfied += customers[right];
            }

            if (grumpy[right] == 1) {
                currentWindowSatisfaction += customers[right];
            }

            if (right - left + 1 > minutes) {
                if (grumpy[left] == 1) {
                    currentWindowSatisfaction -= customers[left];
                }
                left++;
            }

            maxAdditionalSatisfaction = Math.max(maxAdditionalSatisfaction, currentWindowSatisfaction);
        }

        return totalSatisfied + maxAdditionalSatisfaction;
    }
}
