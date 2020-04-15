package medium;

import util.TreeNode;

import java.util.LinkedList;

public class _114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        TreeNode t = root, p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true){
            if (t != null){
                if (t.right != null){
                    stack.push(t.right);
                }
                p.right = t;
                t = t.left;
                p.left = null;
                p = p.right;
            } else if (!stack.isEmpty()){
                t = stack.pop();
            } else {
                break;
            }
        }
    }

    public void flatten_fastest(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            // If the node has a left child
            if (node.left != null) {
                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            // move on to the right side of the tree
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2); t11.left = t12;
        TreeNode t13 = new TreeNode(3); t12.left = t13;
        TreeNode t14 = new TreeNode(4); t12.right = t14;
        TreeNode t15 = new TreeNode(5); t11.right = t15;
        TreeNode t16 = new TreeNode(6); t15.right = t16;

        _114_FlattenBinaryTreetoLinkedList fbtll = new _114_FlattenBinaryTreetoLinkedList();
        fbtll.flatten_fastest(t11);
        int a = 0;
    }
}
