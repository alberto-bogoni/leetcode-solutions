import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Item {
    int val;
    int frequency;
    int sequenceNumber;

    public Item(int v, int f, int s) {
        val = v;
        frequency = f;
        sequenceNumber = s;
    }
}

class FreqStack {

    PriorityQueue<Item> maxHeap;
    Map<Integer, Integer> map;
    int sequenceNumber = 0;

    public FreqStack() {
        maxHeap = new PriorityQueue<>((e1,e2) -> {
            if (e1.frequency == e2.frequency)
                return e2.sequenceNumber - e1.sequenceNumber;
            return e2.frequency - e1.frequency;
        });
        map = new HashMap<>();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxHeap.offer(new Item(val, map.get(val), sequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().val;

        if (map.get(num) > 1)
            map.put(num, map.get(num) - 1);
        else
            map.remove(num);

        return num;
    }
}