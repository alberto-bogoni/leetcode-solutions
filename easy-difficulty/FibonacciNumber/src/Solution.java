import java.util.Arrays;

public class Solution {
    int[] cache;
    public int fib(int n) {
        cache = new int[n+1];
        Arrays.fill(cache, -1);
        return dfs(n);
    }

    public int dfs(int n) {
        if (n <= 1) return n;
        if (cache[n] != -1) return cache[n];
        cache[n] = dfs(n-1) + dfs(n-2);
        return cache[n];
    }
}