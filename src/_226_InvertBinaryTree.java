import java.util.LinkedList;
import java.util.Queue;

public class _226_InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode invertTree_iteration(TreeNode root) {
        if (root == null || root.right == null && root.left == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t, temp;
        queue.add(root);
        while (!queue.isEmpty()){
            t = queue.poll();
            temp = t.left;
            t.left = t.right;
            t.right = temp;
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);

        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;

        TreeNode root = invertTree_iteration(t1);
        System.out.println(root);
    }
}
