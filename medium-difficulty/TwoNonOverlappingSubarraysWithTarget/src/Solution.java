public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int lenghtsSum = 0;

        int windowStart = 0;
        int sum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
           sum += arr[windowEnd];

           if (sum == target) {
              lenghtsSum += windowEnd - windowStart + 1;
           }

           while (sum > target) {
               sum -= arr[windowStart++];
           }
        }

        if (lenghtsSum == 0)
            return -1;
        else
            return lenghtsSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSumOfLengths(new int[]{3,2,2,4,3}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{7,3,4,7}, 7));
        System.out.println(new Solution().minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6));
    }
}
