import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bSet = new HashSet<>();
        for (String b : bank) bSet.add(b);

        if (!bSet.contains(endGene)) return -1;
        if (startGene.equals(endGene)) return 0;

        char[] geneChars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int mutations = 0;
        queue.add(startGene);
        visited.add(startGene);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            mutations++;

            for (int i = 0; i < levelSize; i++) {
                char[] current = queue.poll().toCharArray();

                for (int j = 0; j < current.length; j++) {
                    char original = current[j];

                    for (char c : geneChars) {
                        if (c == original) continue;

                        current[j] = c;
                        String mutation = new String(current);

                        if (mutation.equals(endGene)) {
                            return mutations;
                        }

                        if (bSet.contains(mutation) && !visited.contains(mutation)) {
                            visited.add(mutation);
                            queue.add(mutation);
                        }
                    }
                    current[j] = original;
                }
            }
        }

        return -1;
    }
}