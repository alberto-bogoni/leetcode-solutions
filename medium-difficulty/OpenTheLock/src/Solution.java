import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dSet = new HashSet<>();
        for (String d : deadends) dSet.add(d);

        if (dSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        int level = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    char[] chars = current.toCharArray();
                    char original = chars[j];

                    chars[j] = (original == '9') ? '0' : (char)(original + 1);
                    String up = new String(chars);
                    if (up.equals(target)) return level;
                    if (!dSet.contains(up) && !visited.contains(up)) {
                        visited.add(up);
                        queue.add(up);
                    }

                    chars[j] = original;

                    chars[j] = (original == '0') ? '9' : (char)(original - 1);
                    String down = new String(chars);
                    if (down.equals(target)) return level;
                    if (!dSet.contains(down) && !visited.contains(down)) {
                        visited.add(down);
                        queue.add(down);
                    }

                    chars[j] = original;
                }
            }
        }

        return -1;
    }
}