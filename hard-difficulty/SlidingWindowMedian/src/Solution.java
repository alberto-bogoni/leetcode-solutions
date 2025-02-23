import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> minH = new PriorityQueue<>(Integer::compare);
    PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new double[0];
        int left = 0;


        List<Double> result = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if ((right - left + 1) > k) {
                if (!maxH.isEmpty() && nums[left] <= maxH.peek()) {
                    maxH.remove(nums[left]);
                } else {
                    minH.remove(nums[left]);
                }
                left++;
                rebalanceHeaps();
            }

            if (maxH.isEmpty() || maxH.peek() >= nums[right])
                maxH.add(nums[right]);
            else
                minH.add(nums[right]);
            rebalanceHeaps();

            if (right - left + 1 != k)
                continue;
            double median = 0;
            if (minH.size() == maxH.size()) {
                median = ((double)maxH.peek() + (double)minH.peek()) / 2.0;
            } else {
                median = (double) maxH.peek();
            }
            result.add(median);
        }

        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private void rebalanceHeaps() {
        if (maxH.size() > minH.size() + 1)
            minH.add(maxH.poll());
        else if (maxH.size() < minH.size())
            maxH.add(minH.poll());
    }
}