import util.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class _104_MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null)
			return 0;
		if (root.right == null && root.left == null)
			return 1;
		if (root.right == null)
			return maxDepth(root.left) + 1;
		if (root.left == null)
			return maxDepth(root.right) + 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth_iteration(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int maxdep = stack.size();
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        while (!stack.isEmpty()){
            TreeNode t = stack.peek();
            if (t.left != null && map.get(t.left) == null){
                stack.push(t.left);
                map.put(t.left, true);
            }else if (t.right != null && map.get(t.right) == null) {
                stack.push(t.right);
                map.put(t.right, true);
            }else {
                stack.pop();
            }
            if (stack.size() > maxdep)
                maxdep = stack.size();
        }
        return maxdep;
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

        int maxDepth = maxDepth_iteration(t1);
        System.out.println(maxDepth);
        maxDepth = maxDepth(t1);
        System.out.println(maxDepth);
    }
}
