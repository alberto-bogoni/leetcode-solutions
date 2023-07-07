import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Solution {
    public int totalFruit(int[] fruits) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> fruitFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
           fruitFrequency.put(
                   fruits[windowEnd],
                   fruitFrequency.getOrDefault(fruits[windowEnd], 0) + 1);

           while (fruitFrequency.size() > 2) {
                fruitFrequency.put(fruits[windowStart],
                        fruitFrequency.get(fruits[windowStart]) - 1);

                if (fruitFrequency.get(fruits[windowStart]) == 0) {
                    fruitFrequency.remove(fruits[windowStart]);
                }
                windowStart++;
           }

           maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
