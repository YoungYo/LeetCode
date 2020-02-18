public class MyCircularDeque {
    private int[] values;
    private int capacity; //队列的容量
    private int len; //数组的实际长度，即values.length
    private int head = 0, rear = 1, size = 0;
     /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        values = new int[k + 1];
        capacity = k;
        len = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity)
            return false;
        values[head] = value;
        head = (head + capacity) % len;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity)
            return false;
        values[rear] = value;
        rear = (rear + 1) % len;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0)
            return false;
        head = (head + 1) % len;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0)
            return false;
        rear = (rear + capacity) % len;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0)
            return -1;
        return values[(head + 1) % len];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0)
            return -1;
        return values[(rear + capacity) % len];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(9);
		boolean param_1 = obj.insertFront(3);
		boolean param_2 = obj.insertLast(6);
		boolean param_3 = obj.deleteFront();
		boolean param_4 = obj.deleteLast();
		int param_5 = obj.getFront();
		int param_6 = obj.getRear();
		boolean param_7 = obj.isEmpty();
		boolean param_8 = obj.isFull();
    }
}
