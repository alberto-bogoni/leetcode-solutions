import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int c = 0; c < nums.length; c++) {
            if (nums[c] != c + 1) {
                result.add(nums[c]);
            }
        }

        return result;
    }
}