import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = subsets.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        
        return subsets;
    }

    public List<List<Integer>> subsetsWithDupSecond(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> set, List<List<Integer>> result) {

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            set.add(nums[i]);
            result.add(new ArrayList<Integer>(set));
            backtrack(nums, i + 1, set, result);
            set.removeLast();
        }
    }
}