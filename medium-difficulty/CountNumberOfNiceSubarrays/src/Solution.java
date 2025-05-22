public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return nice(nums, k) - nice(nums, k - 1);
    }

    public int nice(int[] nums, int k) {
        if (k < 0) return 0;

        int count = 0;
        int odd = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) odd++;

            while (odd > k)
                if (nums[left++] % 2 == 1) odd--;

            count += right - left + 1;
        }

        return count;
    }
}