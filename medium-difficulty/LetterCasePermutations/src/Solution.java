import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new LinkedList<>();
        Queue<String> permutations = new LinkedList<>();
        permutations.add("");

        for (int i = 0; i < s.length(); i++) {
            int n = permutations.size();

            for (int j = 0; j < n; j++) {
                String current = permutations.poll();

                if (Character.isDigit(s.charAt(i))) {
                    permutations.add(current + s.charAt(i));
                } else {
                    char ch = s.charAt(i);
                    permutations.add(current + Character.toLowerCase(ch));
                    permutations.add(current + Character.toUpperCase(ch));
                }
            }
        }

        result.addAll(permutations);
        return result;
    }

    public List<String> letterCasePermutationSecondApproach(String s) {
        List<String> permutations = new ArrayList<>();
        if (s == null)
            return permutations;

        permutations.add(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}