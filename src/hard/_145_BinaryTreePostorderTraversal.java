package hard;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class _145_BinaryTreePostorderTraversal {
    private List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
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
        if (root.right != null){
            recursive(root.right);
        }
        res.add(root.val);
    }

    public List<Integer> postorderTraversal_iterate(TreeNode root) {
        res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        if (t != null){
            stack.push(t);
        }
        while (!stack.isEmpty()){
            if (stack.peek().right != t && stack.peek().left != t){
                while ((t = stack.peek()) != null){
                    if (t.left != null){
                        if (t.right != null){
                            stack.push(t.right);
                        }
                        stack.push(t.left);
                    }else {
                        stack.push(t.right);
                    }
                }
                stack.pop();
            }
            t = stack.pop();
            res.add(t.val);
        }
        return res;
    }
    public static void main(String[] args) {
        _145_BinaryTreePostorderTraversal btpt = new _145_BinaryTreePostorderTraversal();
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2); t11.right = t12;
        TreeNode t13 = new TreeNode(3); t12.left = t13;

        TreeNode t21 = new TreeNode(4);
        TreeNode t = t11;
        btpt.postorderTraversal(t);
        btpt.res.forEach(System.out::println);

        btpt.postorderTraversal_iterate(t);
        btpt.res.forEach(System.out::println);
    }
}
