public class Solution {
    public boolean isArraySpecial(int[] nums) {
        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.length) {
            if (nums[p1] % 2 == 0 && nums[p2] % 2 == 0) return false;
            else if (nums[p1] % 2 != 0 && nums[p2] % 2 != 0) return false;
            p1++;
            p2++;
        }

        return true;
    }
}