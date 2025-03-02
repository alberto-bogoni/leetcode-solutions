public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        int bitCount = 0;
        int num = n;
        while (num > 0) {
            bitCount++;
            num = num >> 1;
        }

        int all_bits_set = (int) Math.pow(2, bitCount) - 1;

        return n ^ all_bits_set;
    }
}