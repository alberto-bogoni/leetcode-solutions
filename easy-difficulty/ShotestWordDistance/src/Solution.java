/*
    Given an array of strings words and two different strings that already exist in the array word1 and word2, return
    the shortest distance between these two words in the list.
*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortestDistance = Integer.MAX_VALUE;

        int word2Index = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word2)) {
                word2Index = i;
                break;
            }
        }

        for (int i = 0; i < words.length; i++) {
            int positive = convertToPositiveIfNecessary(i - word2Index);
            if (words[i].equals(word1) && positive < shortestDistance)
                shortestDistance = positive;
        }

        return shortestDistance;
    }

    public int convertToPositiveIfNecessary(int number) {
        return (number < 0) ? number *= -1 : number;
    }
}
