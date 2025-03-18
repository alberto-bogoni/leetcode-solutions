public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target < letters[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }

        return letters[left % letters.length];
    }

    public char nextGreatestLetterSecond(char[] letters, char target) {
        return search(letters, 0, letters.length-1, target);
    }

    public char search(char[] letters, int start, int end, char target) {
        if (start >= letters.length) return letters[0];
        if (start > end) return letters[start];

        int mid = start + (end - start) / 2;
        if (letters[mid] > target) {
            return search(letters, start, mid - 1, target);
        } else {
            return search(letters, mid + 1, end, target);
        }
    }
}