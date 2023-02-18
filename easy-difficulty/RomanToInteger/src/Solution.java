import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Object, Integer> atomicRomanNumbersValues = new HashMap<Object, Integer>();
        atomicRomanNumbersValues.put('I', 1);
        atomicRomanNumbersValues.put('V', 5);
        atomicRomanNumbersValues.put('X', 10);
        atomicRomanNumbersValues.put('L', 50);
        atomicRomanNumbersValues.put('C', 100);
        atomicRomanNumbersValues.put('D', 500);
        atomicRomanNumbersValues.put('M', 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            int currentRoman = atomicRomanNumbersValues.get(s.charAt(i));
            int nextRoman = (i + 1 <= s.length() - 1) ? atomicRomanNumbersValues.get(s.charAt(i + 1)) : 0;

            if ((nextRoman == currentRoman * 5) || (nextRoman == currentRoman * 10)) {
                result += atomicRomanNumbersValues.get(s.charAt(i + 1)) - atomicRomanNumbersValues.get(s.charAt(i));
                i += 2;
            } else {
                result += atomicRomanNumbersValues.get(s.charAt(i));
                i++;
            }
        }

        return result;
    }
}
