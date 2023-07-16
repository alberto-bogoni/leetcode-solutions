import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final int windowSize = 10;
        List<String> result = new ArrayList<>();
        Map<String, Integer> dnaFrequencies = new HashMap<>();

        StringBuilder builder = new StringBuilder();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            builder.append(s.charAt(windowEnd));

            if (builder.length() == windowSize) {
                String dnaSequence = builder.toString();
                dnaFrequencies.put(builder.toString(), dnaFrequencies.getOrDefault(dnaSequence, 0) + 1);

                if (dnaFrequencies.get(dnaSequence) > 1 & !result.contains(dnaSequence))
                    result.add(dnaSequence);

                builder.deleteCharAt(0);
            }
        }

        return result;
    }
}
