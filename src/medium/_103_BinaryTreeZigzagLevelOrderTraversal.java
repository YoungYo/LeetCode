package medium;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class _103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (Objects.isNull(root)){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int flag = 1;
        while (!stack.empty()){
            Stack<TreeNode> helperStack = new Stack<>();
            List<Integer> curLevel = new LinkedList<>();
            while (!stack.empty()){
                TreeNode x = stack.pop();
                curLevel.add(x.val);
                TreeNode child1 = flag < 0 ? x.right : x.left;
                TreeNode child2 = flag < 0 ? x.left : x.right;
                if (Objects.nonNull(child1)){
                    helperStack.push(child1);
                }
                if (Objects.nonNull(child2)){
                    helperStack.push(child2);
                }
            }
            if (!curLevel.isEmpty()){
                res.add(curLevel);
            }
            stack = helperStack;
            flag *= -1;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9); t1.left = t2;
        TreeNode t3 = new TreeNode(20); t1.right = t3;
        TreeNode t4 = new TreeNode(15); t3.left = t4;
        TreeNode t5 = new TreeNode(7); t3.right = t5;

        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(2); t6.left = t7;

        _103_BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new _103_BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> res = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(t1);
        res.forEach(System.out::println);
    }
}
