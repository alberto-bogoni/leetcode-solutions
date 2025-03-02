public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            int bitSum = 0;

            for (int num : nums) {
                if (((num >> bitPosition) & 1) == 1) {
                    bitSum++;
                }
            }

            if (bitSum % 3 != 0) {
                result |= (1 << bitPosition);
            }
        }

        return result;
    }
}