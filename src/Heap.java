import java.util.PriorityQueue;

public class Heap {
    int capacity;
    int[] array;

    public Heap(int capacity){
        array = new int[capacity];
    }

    public void insert(int value){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.poll();
        queue.peek();
    }
}
