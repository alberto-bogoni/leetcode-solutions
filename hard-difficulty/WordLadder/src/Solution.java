import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        wordSet.add(beginWord);
        Map<String, List<String>> adjList = buildAdjList(wordSet);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;

                for (String neighbor : adjList.get(word)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private static Map<String, List<String>> buildAdjList(Set<String> wordSet) {
        Map<String, List<String>> patternMap = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        int wordLen = wordSet.iterator().next().length();

        for (String word : wordSet) {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        for (String word : wordSet) {
            adjList.put(word, new ArrayList<>());
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String neighbor : patternMap.getOrDefault(pattern, new ArrayList<>())) {
                    if (!neighbor.equals(word)) {
                        adjList.get(word).add(neighbor);
                    }
                }
            }
        }

        return adjList;
    }
}