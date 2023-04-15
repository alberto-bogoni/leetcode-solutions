/*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*/

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] charactersOfS = s.toCharArray();
        char[] charactersOfT = t.toCharArray();

        Arrays.sort(charactersOfS);
        Arrays.sort(charactersOfT);

        for (int i = 0; i < charactersOfS.length; i++) {
            if (charactersOfS[i] != charactersOfT[i]) {
                return false;
            }
        }

        return true;
    }
}
