import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int result = 0;
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);

            if (maxFreq < freqMap.get(n)) {
                maxFreq = freqMap.get(n);
                result = maxFreq;
            }
            else if (maxFreq == freqMap.get(n)) result += maxFreq;
        }

        return result;
    }

    public int maxFrequencyElementsHashMapSolution(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int result = 0;
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
            maxFreq = Math.max(freqMap.get(n), maxFreq);
        }

        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            if (e.getValue() == maxFreq)
                result += e.getValue();
        }

        return result;
    }
}