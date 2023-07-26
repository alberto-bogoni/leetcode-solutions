public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxNumberOfCustomers = Integer.MIN_VALUE;

        int windowStart = 0;
        int currentCustomersSatisfied = 0;
        int grumpyTimeslicesInMinutes = 0;

        for (int windowEnd = 0; windowEnd < grumpy.length; windowEnd++) {
            currentCustomersSatisfied += customers[windowEnd];
            if (grumpy[windowEnd] == 1)
               grumpyTimeslicesInMinutes += 1;

            while (grumpyTimeslicesInMinutes > minutes) {
               if (grumpy[windowStart] == 1) {
                   grumpyTimeslicesInMinutes--;
               }
               currentCustomersSatisfied -= customers[windowStart];

               windowStart++;
            }

            maxNumberOfCustomers = Math.max(maxNumberOfCustomers, currentCustomersSatisfied);
        }

        return maxNumberOfCustomers;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(new Solution().maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }
}
