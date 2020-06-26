package hard;

import util.TreeNode;

import java.util.Objects;

public class _124_BinaryTreeMaximumPathSum {

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxDownPathSum(root);
        return maxValue;
    }

    private int maxDownPathSum(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int leftMax = Math.max(0, maxDownPathSum(node.left));
        int rightMax = Math.max(0, maxDownPathSum(node.right));
        maxValue = Math.max(maxValue, leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
    }

    public static void main(String[] args) {
        _124_BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new _124_BinaryTreeMaximumPathSum();
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2); t11.left = t12;
        TreeNode t13 = new TreeNode(3); t11.right = t13;

        TreeNode t21 = new TreeNode(-10);
        TreeNode t22 = new TreeNode(9); t21.left = t22;
        TreeNode t23 = new TreeNode(20); t21.right = t23;
        TreeNode t24 = new TreeNode(15); t23.left = t24;
        TreeNode t25 = new TreeNode(7); t23.right = t25;

        TreeNode[] test = {t11, t21};

        for (TreeNode root : test) {
            System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
        }
    }
}
