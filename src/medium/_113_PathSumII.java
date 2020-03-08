package medium;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _113_PathSumII {
    public List<List<Integer>> pathSum_iteration(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        int[] path = new int[maxDepth(root)];
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> level = new Stack<>(); //记录当前访问到第几层了
        Stack<Integer> path_sum = new Stack<>(); //记录根结点到当前结点的路径和
        int val = root.val;
        nodeStack.push(root);
        level.push(0);
        path_sum.push(val);
        while (!nodeStack.isEmpty()){
            TreeNode t = nodeStack.pop();
            int curLevel = level.pop();
            val = path_sum.pop();
            path[curLevel] = t.val;
            if (t.left == null && t.right == null && sum == val) { //到达了叶子结点，且路径总和正好等于sum
                List<Integer> al = new ArrayList<>(curLevel + 1);
                for(int i = 0; i <= curLevel; i++){
                    al.add(path[i]);
                }
                res.add(al);
            }
            if (t.left != null){
                nodeStack.push(t.left);
                path_sum.push(val + t.left.val);
                level.push(curLevel + 1);
            }
            if (t.right != null){
                nodeStack.push(t.right);
                path_sum.push(val + t.right.val);
                level.push(curLevel + 1);
            }
        }
        return res;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int[] path = new int[maxDepth(root)];
        if (root != null){
            pathSum(res, path, root, sum, 0);
        }
        return res;
    }

    public void pathSum(List<List<Integer>> res, int[] curPath, TreeNode root, int sum, int idx){
        if (root.left == null && root.right == null){
            if (root.val == sum){
                curPath[idx] = root.val;
                List<Integer> al = new ArrayList<>(idx+1);
                for(int i = 0; i <= idx; i++){
                    al.add(curPath[i]);
                }
                res.add(al);
            }
            return;
        }

        curPath[idx] = root.val;
        if (root.left != null){
            pathSum(res, curPath, root.left, sum - root.val, idx + 1);
        }
        if (root.right != null){
            pathSum(res, curPath, root.right, sum - root.val, idx + 1);
        }
    }

    private int maxDepth(TreeNode root) {
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
    public static void main(String[] args) {
        _113_PathSumII ps2 = new _113_PathSumII();

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4); t1.left = t2;
        TreeNode t3 = new TreeNode(8); t1.right = t3;
        TreeNode t4 = new TreeNode(11); t2.left = t4;
        TreeNode t5 = new TreeNode(7); t4.left = t5;
        TreeNode t6 = new TreeNode(2); t4.right = t6;
        TreeNode t7 = new TreeNode(13); t3.left = t7;
        TreeNode t8 = new TreeNode(4); t3.right = t8;
        TreeNode t9 = new TreeNode(5); t8.left = t9;
        TreeNode t10 = new TreeNode(1); t8.right = t10;

        TreeNode t21 = new TreeNode(-2);
        TreeNode t22 = new TreeNode(-3); t21.right = t22;

        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(-2); t31.left = t32;
        TreeNode t33 = new TreeNode(3); t31.right = t33;

        TreeNode t = t1;
        int sum = 22;
        List<List<Integer>> res = ps2.pathSum(t, sum);
        List<List<Integer>> res1 = ps2.pathSum_iteration(t, sum);

        for(List<Integer> list: res){
            for(Integer i: list){
                System.out.printf("%d, ", i);
            }
            System.out.println();
        }

        for(List<Integer> list: res1){
            for(Integer i: list){
                System.out.printf("%d, ", i);
            }
            System.out.println();
        }
    }
}
