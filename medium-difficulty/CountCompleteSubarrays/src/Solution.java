import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distincts = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer n : nums) {
            distincts.add(n);
        }

        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() == distincts.size()) {
                count += nums.length - right;
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
        }

        return count;
    }
}