import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int size = stack.size();
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = stack.pop();
        }

        stack.push(x);

        for (int i = temp.length - 1; i >= 0; i--) {
            stack.push(temp[i]);
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
