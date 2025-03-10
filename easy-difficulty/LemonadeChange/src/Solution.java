public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5)
            return false;

        // 0 -> 5, 1 -> 10, 2 -> 20
        int[] stock = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 10) {
                if (stock[0] < 0)
                    return false;
                stock[0]--;
            } else if (bills[i] == 20) {
                boolean tenAndFive = stock[0] > 0 && stock[1] > 0;
                boolean threeTimesFive = stock[0] >= 3;

                if (tenAndFive) {
                    stock[0]--;
                    stock[1]--;
                } else if (threeTimesFive) {
                    stock[0] -= 3;
                } else {
                    return false;
                }
            }

            if (bills[i] == 5)
                stock[0]++;
            else if (bills[i] == 10)
                stock[1]++;
            else
                stock[2]++;
        }

        return true;
    }
}