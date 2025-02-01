import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new LinkedList<>();

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (int c = 0; c < nums.length; c++) {
            if (nums[c] != c + 1) {
                missingNumbers.add(c + 1);
            }
        }

        return missingNumbers;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}