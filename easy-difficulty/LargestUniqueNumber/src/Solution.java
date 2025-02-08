import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            if (map.get(A[i]) == 1)
                return A[i];
        }

        return -1;
    }
}