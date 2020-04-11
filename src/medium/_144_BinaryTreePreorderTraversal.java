package medium;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {
    private List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        if (root == null){
            return res;
        }
        recursive(root);
        return res;
    }

    private void recursive(TreeNode root){
        res.add(root.val);
        if (root.left != null){
            recursive(root.left);
        }
        if (root.right != null){
            recursive(root.right);
        }
    }

    public List<Integer> preorderTraversal_iterate(TreeNode root) {
        res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        while (true){
            if (t != null){
                res.add(t.val);
                if (t.right != null){
                    stack.push(t.right);
                }
                t = t.left;
            }else if (!stack.isEmpty()){
                t = stack.pop();
            }else {
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        _144_BinaryTreePreorderTraversal btpt = new _144_BinaryTreePreorderTraversal();

        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2); t11.right = t12;
        TreeNode t13 = new TreeNode(3); t12.left = t13;

        TreeNode t21 = new TreeNode(4);
        TreeNode t = t11;
        btpt.preorderTraversal(t);
        btpt.res.forEach(System.out::println);

        btpt.preorderTraversal_iterate(t);
        btpt.res.forEach(System.out::println);
    }
}
