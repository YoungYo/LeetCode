package medium;

import util.Node;
import java.util.Objects;

public class _116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Node leftmost = root;
        while (Objects.nonNull(leftmost) && Objects.nonNull(leftmost.left) && Objects.nonNull(leftmost.right)) {
            Node currNode = leftmost;
            while (Objects.nonNull(currNode)) {
                currNode.left.next = currNode.right;
                if (Objects.nonNull(currNode.next)) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        _116_PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new _116_PopulatingNextRightPointersInEachNode();
        Node n11 = new Node(1);
        Node n12 = new Node(2); n11.left = n12;
        Node n13 = new Node(3); n11.right = n13;
        Node n14 = new Node(4); n12.left = n14;
        Node n15 = new Node(5); n12.right = n15;
        Node n16 = new Node(6); n13.left = n16;
        Node n17 = new Node(7); n13.right = n17;

        Node[] test = {n11};
        for (Node node : test) {
            node = populatingNextRightPointersInEachNode.connect(node);
            int a = 0;
        }
    }
}
