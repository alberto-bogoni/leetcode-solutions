import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int windowStart = 0;
        int recolorsCount = 0;
        int minimumRecolors = Integer.MAX_VALUE;
        Map<Character, Integer> colorFrequencies = new HashMap<>();

        for (int windowEnd = 0; windowEnd < blocks.length(); windowEnd++) {
            if (blocks.charAt(windowEnd) == 'W')
                recolorsCount++;

            if (windowEnd - windowStart + 1 == k) {
                minimumRecolors = Math.min(minimumRecolors, recolorsCount);

                if (blocks.charAt(windowStart) == 'W')
                    recolorsCount--;

                windowStart++;
            }
        }

        return minimumRecolors;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRecolors("BWWWBB", 6));
    }
}
