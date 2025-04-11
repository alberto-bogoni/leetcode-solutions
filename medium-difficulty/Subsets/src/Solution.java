import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int currentNumber : nums) {
            int n = subsets.size();

            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current
                // element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }

        return subsets;
    }

    public List<List<Integer>> subsetsSecond(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> set, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            res.add(new ArrayList<>(set));

            backtrack(nums, i + 1, set, res);

            set.remove(set.size() - 1);
        }
    }
}