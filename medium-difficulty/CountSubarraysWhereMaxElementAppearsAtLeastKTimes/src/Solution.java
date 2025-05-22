public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;

        int target = 0;
        for (int i = 0; i < nums.length; i++) target = Math.max(target, nums[i]);

        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == target) maxFreq++;

            while (maxFreq >= k) {
                if (nums[left] == target) maxFreq--;
                left++;
            }

            count += right - left + 1;
        }

        long total = (long) nums.length * (nums.length + 1) / 2;

        return total - count;
    }
}