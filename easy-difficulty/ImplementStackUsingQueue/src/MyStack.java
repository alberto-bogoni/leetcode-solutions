import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);

        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
