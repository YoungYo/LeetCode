package medium;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        if (root == null){
            return res;
        }
        recursive(root);
        return res;
    }

    private void recursive(TreeNode root){
        if (root.left != null){
            recursive(root.left);
        }
        res.add(root.val);
        if (root.right != null){
            recursive(root.right);
        }
    }

    public List<Integer> inorderTraversal_iterate(TreeNode root) {
        res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        while (true){
            if (t != null){
                stack.push(t);
                t = t.left;
            }else if (!stack.isEmpty()){
                t = stack.pop();
                res.add(t.val);
                t = t.right;
            }else {
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        _94_BinaryTreeInorderTraversal btit = new _94_BinaryTreeInorderTraversal();

        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2); t11.right = t12;
        TreeNode t13 = new TreeNode(3); t12.left = t13;

        TreeNode t21 = new TreeNode(4);
        TreeNode t = t21;
        btit.inorderTraversal(t);
        btit.res.forEach(System.out::println);
        btit.inorderTraversal_iterate(t);
        btit.res.forEach(System.out::println);
    }
}
