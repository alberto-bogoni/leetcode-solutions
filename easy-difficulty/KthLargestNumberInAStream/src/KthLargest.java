import java.util.Map;
import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private Integer k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;

        for (Integer n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();
    }
}