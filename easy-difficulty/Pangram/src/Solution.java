import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        final int NUMBER_OF_CHARACTERS_ALPHABET = 26;

        if (sentence.length() < NUMBER_OF_CHARACTERS_ALPHABET)
            return false;

        HashSet<Character> alphabetCharacters = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            alphabetCharacters.add(sentence.charAt(i));
        }

        return alphabetCharacters.size() == NUMBER_OF_CHARACTERS_ALPHABET;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
