import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> tr, int l, int p, Integer[][] memo) {
        if (l == tr.size() - 1) {
            return tr.get(l).get(p);
        }

        if (memo[l][p] != null) {
            return memo[l][p];
        }

        int cur = tr.get(l).get(p);

        int down = dfs(tr, l + 1, p, memo);
        int downRight = dfs(tr, l + 1, p + 1, memo);

        memo[l][p] = cur + Math.min(down, downRight);
        return memo[l][p];
    }
}