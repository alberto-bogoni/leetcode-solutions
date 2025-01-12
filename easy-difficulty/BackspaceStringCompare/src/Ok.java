import java.util.*;

public class Ok {
    public static void main(String[] args) {
        moveZeroes(new int[]{2,1});
        repeatedCharacter("abccbaacz");
        threeSumClosest(new int[]{-1,2,1,-4}, 1);
        threeSumSmaller(new int[]{-1, 0, 2, 3}, 3);
        threeSumSmaller(new int[]{-1, 4, 2, 1, 3}, 5);
        backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public static void moveZeroes(int[] nums) {
        int nextNonZero = 0;

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[nextNonZero++] = temp;
            }
        }
    }

    // 2351 First letter to appear twice.
    public static char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if ((map.getOrDefault(s.charAt(i), 0) + 1) == 2) {
                return s.charAt(i);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        return 'z';
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                } else if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closestSum;
    }

    public static List<List<Integer>> threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum < target) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));

                    int supportRight = right;
                    while (left < supportRight) {
                        supportRight--;
                        if (left == supportRight)
                            continue;
                        triplets.add(List.of(nums[i], nums[left], nums[supportRight]));
                    }

                    left++;
                    right--;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int count = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k && left < nums.length) {
                product /= nums[left++];
            }
            count += right - left + 1;
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int left = 0;
        int sum = 0;

        return count;
    }

    public static boolean backspaceCompare(String s, String t) {

        int position = 0;
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (position > 0 && s.charAt(i) == '#') {
                sBuilder.deleteCharAt(position - 1);
                position--;
            } else if (s.charAt(i) != '#') {
                sBuilder.append(s.charAt(i));
                position++;
            }
        }

        position = 0;
        StringBuilder sBuilder2 = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (position > 0 && t.charAt(i) == '#') {
                sBuilder2.deleteCharAt(position - 1);
                position--;
            } else if (t.charAt(i) != '#') {
                sBuilder2.append(t.charAt(i));
                position++;
            }
        }

        return sBuilder.toString().equals(sBuilder2.toString());
    }
}
