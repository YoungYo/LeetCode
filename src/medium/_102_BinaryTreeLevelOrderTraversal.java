package medium;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        _102_BinaryTreeLevelOrderTraversal btlot = new _102_BinaryTreeLevelOrderTraversal();

        TreeNode t11 = new TreeNode(3);
        TreeNode t12 = new TreeNode(9); t11.left = t12;
        TreeNode t13 = new TreeNode(20); t11.right = t13;
        TreeNode t14 = new TreeNode(15); t13.left = t14;
        TreeNode t15 = new TreeNode(7); t13.right = t15;

        TreeNode t21 = new TreeNode(1);

        TreeNode t = null;
        System.out.println(btlot.levelOrder(t).toString());
    }
}
