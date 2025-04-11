import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(candidates, 0, target, new LinkedList<Integer>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;

            comb.add(candidates[i]);

            backtrack(candidates, i, target - candidates[i], comb, result);

            comb.remove(comb.size() - 1);
        }
    }
}