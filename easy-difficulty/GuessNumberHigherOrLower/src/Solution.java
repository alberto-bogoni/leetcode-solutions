public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return search(1, n);
    }

    public int search(int start, int end) {

        int mid = start + (end - start) / 2;
        if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == -1) {
            return search(start, mid - 1);
        } else {
            return search(mid + 1, end);
        }
    }
}

class GuessGame {
    public int guess(int n) {
       return 0; // placeholder.
    }
}