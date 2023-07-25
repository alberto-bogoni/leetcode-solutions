import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxTrueAnswers = maxAnswers(answerKey, k, 'T');
        int maxFalseAnswers = maxAnswers(answerKey, k, 'F');

        return Math.max(maxTrueAnswers, maxFalseAnswers);
    }

    public int maxAnswers(String answerKey, int k, Character answer) {
        int maxLength = 0;

        Map<Character, Integer> charFrequency = new HashMap<>();

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < answerKey.length(); windowEnd++) {
            char rightChar = answerKey.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            if (charFrequency.getOrDefault(answer, 0) == k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }

            while (charFrequency.getOrDefault(answer, 0) > k) {
                char leftChar = answerKey.charAt(windowStart++);
                if (leftChar == answer)
                    charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
            }
        }

        return maxLength;
    }
}
