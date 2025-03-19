class MinStack {

    int[] nums;
    int[] min;
    int top;

    public MinStack() {
        nums = new int[10];
        top = 0;
        min = new int[10];
    }

    public void push(int val) {
        if (top == nums.length) {
            resize();
        }

        nums[top] = val;
        if (top == 0) {
            min[top] = val;
        } else {
            min[top] = Math.min(val, min[top - 1]);
        }
        top++;
    }

    private void resize() {
        int newSize = nums.length * 2;
        int[] newData = new int[newSize];
        int[] newMinStack = new int[newSize];
        System.arraycopy(nums, 0, newData, 0, nums.length);
        System.arraycopy(min, 0, newMinStack, 0, nums.length);
        nums = newData;
        min = newMinStack;
    }

    public void pop() {
        top--;
    }

    public int top() {
        return nums[top - 1];
    }

    public int getMin() {
        return min[top - 1];
    }
}
