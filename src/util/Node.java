package util;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
