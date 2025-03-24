import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        int mostFrequent = 0;
        int left = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            Character response = answerKey.charAt(right);
            map.put(response, map.getOrDefault(response, 0) + 1);
            mostFrequent = Math.max(map.get(response), mostFrequent);

            if (right - left + 1 - mostFrequent > k) {
                map.put(answerKey.charAt(left), map.get(answerKey.charAt(left)) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}