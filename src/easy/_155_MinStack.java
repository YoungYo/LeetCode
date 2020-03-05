package easy;

import util.ListNode;

public class _155_MinStack {
    private ListNode head;
    private ListNode min;
    /** initialize your data structure here. */
    public _155_MinStack() {
        head = new ListNode(0);
        min = new ListNode(Integer.MIN_VALUE);
    }

    public void push(int x) {
        ListNode p = head.next;
        head.next = new ListNode(x);
        head.next.next = p;

        p = min;
        while (true){
            if (p.next == null){
                p.next = new ListNode(x);
                break;
            }
            else if (p.val <= x && x < p.next.val){
                ListNode tmp = p.next;
                p.next = new ListNode(x);
                p.next.next = tmp;
                break;
            }
            p = p.next;
        }
    }

    public void pop() {
        if (head.next == null)
            return;
        int x = head.next.val;
        head.next = head.next.next;
        ListNode p = min;
        while (true){
            if (p.next.val == x){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }

    public int top() {
        if (head.next == null)
            return 0;
        else
            return head.next.val;
    }

    public int getMin() {
        return min.next == null ? -65535 : min.next.val;
    }

    public static void main(String[] args) {
        _155_MinStack minStack = new _155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        int a = minStack.getMin();
        int b = minStack.top();
        minStack.pop();
        int c = minStack.getMin();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
