package medium;

import util.TreeNode;
import java.util.Stack;

public class _98_ValidateBinarySearchTree {

    /** 递归法 */
    public static boolean isValidBST_recursive(TreeNode root) {
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        return helper(node.left, lower, val) && helper(node.right, val, upper);
    }

    /** 将递归转换成迭代*/
    public static boolean isValidBST_iteration(TreeNode root){
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> lower = new Stack<>();
        Stack<Integer> upper = new Stack<>();

        stack.push(root); lower.add(null); upper.add(null);
        TreeNode t;
        Integer low_limit, up_limit;
        while (!stack.isEmpty()){
            t = stack.pop();
            low_limit = lower.pop();
            up_limit = upper.pop();
            if (t == null)
                continue;

            int val = t.val;
            if (low_limit != null && low_limit >= val)
                return false;
            if (up_limit != null && up_limit <= val)
                return false;
            stack.push(t.right); lower.push(val); upper.push(up_limit);
            stack.push(t.left); lower.push(low_limit); upper.push(val);
        }
        return true;
    }

    /** 中序遍历法 */
    public static boolean isValidBST_inorder(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        int preval = Integer.MIN_VALUE;
        boolean begin = false; //开始遍历的标识
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (true){
            if (t != null){
                stack.push(t);
                t = t.left;
            }else if (!stack.isEmpty()){
                t = stack.pop();
//                System.out.print(t.val + ", ");
                if (begin && t.val <= preval) {
                    return false;
                }else {
                    preval = t.val;
                    t = t.right;
                    begin = true;
                }
            }else {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7); t1.left = t2; t1.right = t3;
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3); t2.left = t4; t2.right = t5;
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9); t3.left = t6; t3.right = t7;

        TreeNode t8 = new TreeNode(34);
        TreeNode t9 = new TreeNode(-6); t8.right = t9;
        TreeNode t10 = new TreeNode(-21); t9.right = t10;

        TreeNode t11 = new TreeNode(Integer.MIN_VALUE);
        t11.left = new TreeNode(Integer.MIN_VALUE);

        TreeNode t41 = new TreeNode(10);
        TreeNode t42 = new TreeNode(5); t41.left = t42;
        TreeNode t43 = new TreeNode(15); t41.right = t43;
        TreeNode t44 = new TreeNode(6); t43.left = t44;
        TreeNode t45 = new TreeNode(20); t43.right = t45;
        System.out.println(isValidBST_recursive(t41));
        System.out.println(isValidBST_iteration(t41));
        System.out.println(isValidBST_inorder(t41));
    }
}
