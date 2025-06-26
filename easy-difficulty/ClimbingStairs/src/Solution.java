import java.util.Arrays;

public class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        Arrays.fill(cache, -1);
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 0 || n == 1) return 1;
        if (cache[n] != -1) return cache[n];
        cache[n] = dfs(n-1) + dfs(n-2);
        return cache[n];
    }
}