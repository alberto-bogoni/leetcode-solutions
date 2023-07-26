import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultIndexes = new LinkedList<>();

        int wordLength = words[0].length();

        Map<String, Integer> charFrequencyMap = new HashMap<>();
        int absFrequency = 0;
        for (int i = 0; i < words.length; i++) {
                charFrequencyMap.put(
                        words[i],
                        charFrequencyMap.getOrDefault(words[i], 0) + 1
                );
                absFrequency++;
        }

        int windowStart = 0;
        int matched = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd += wordLength) {
           String justBuiltString = s.substring(windowEnd, windowEnd + wordLength);
           if (charFrequencyMap.containsKey(justBuiltString)) {
               charFrequencyMap.put(justBuiltString, charFrequencyMap.get(justBuiltString) - 1);
               if (charFrequencyMap.get(justBuiltString) == 0)
                   matched++;
           }

           if (matched == charFrequencyMap.size()) {
               resultIndexes.add(windowStart);
           }

           if ((windowEnd / wordLength) >= absFrequency - 1) {
               String leftWord = s.substring(windowStart, windowStart + wordLength);
               windowStart += wordLength;
               if (charFrequencyMap.containsKey(leftWord)) {
                   if (charFrequencyMap.get(leftWord) == 0) {
                       matched--;
                   }
                   charFrequencyMap.put(leftWord, charFrequencyMap.get(leftWord) + 1);
               }
           }
        }

        return resultIndexes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
