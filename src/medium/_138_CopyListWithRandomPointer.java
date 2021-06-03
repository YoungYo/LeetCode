package medium;

import util.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 王浩
 * @date 2021/6/3 上午11:15
 */
public class _138_CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node t = head;
        Node newNode = new Node(head.val);
        Node temp = newNode;
        nodeMap.put(t, temp);
        t = t.next;
        while (t != null) {
            temp.next = new Node(t.val);
            temp = temp.next;
            nodeMap.put(t, temp);
            t = t.next;
        }
        t = head;
        temp = newNode;
        while (t != null) {
            temp.random = nodeMap.get(t.random);
            temp = temp.next;
            t = t.next;
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13); a.next = b;
        Node c = new Node(11); b.next = c;
        Node d = new Node(10); c.next = d;
        Node e = new Node(1); d.next = e;

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        Node newNode = copyRandomList(a);
        int n = 1;
    }
}
