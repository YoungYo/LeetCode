package easy;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _437_PathSumIII {
    public int pathSum_iterationTraversal(TreeNode root, int sum){ //采用迭代的方式遍历二叉树，每访问到一个结点，就调用 helper 函数
        if (root == null)
            return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (true){
            while (t != null){
                res += helper(t, sum);
                if (t.right != null){
                    stack.push(t.right);
                }
                t = t.left;
            }
            if (stack.empty()) break;
            t = stack.pop();
        }
        return res;
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = 0;
        res += helper(root, sum);
        if (root.left != null){
            res += pathSum(root.left, sum);
        }
        if (root.right != null){
            res += pathSum(root.right, sum);
        }
        return res;
    }

    public int helper(TreeNode root, int sum) {
        int res = 0;
        if (root.val == sum){
            res += 1;
        }
        if (root.left != null){
            res += helper(root.left, sum - root.val);
        }
        if (root.right != null){
            res += helper(root.right, sum - root.val);
        }
        return res;
    }

    public int pathSum_prefixSumRecursive(TreeNode root, int sum) { //前缀和递归版
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumFrom(root, 0, sum, map);
    }
    private int pathSumFrom(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if (root == null)
            return 0;
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += pathSumFrom(root.left, sum, target, map)
                + pathSumFrom(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public int pathSum_prefixSumIteration(TreeNode root, int sum) { //前缀和迭代版
        if (root == null)
            return 0;
        int res = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> prefixSumStack = new Stack<>();
        Map<TreeNode, Boolean> map = new HashMap<>();
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        nodes.push(root);
        prefixSumStack.push(root.val);
        prefixSumMap.put(0, 1);

        int val = 0;
        while (!nodes.isEmpty()){
            TreeNode t = nodes.peek();
            val = prefixSumStack.peek();
            if (map.get(t) == null){
                res += prefixSumMap.getOrDefault(val - sum, 0);
                prefixSumMap.put(val, prefixSumMap.getOrDefault(val, 0) + 1);
                map.put(t, true);
            }
            if (t.left != null && map.get(t.left) == null){
                nodes.push(t.left);
                prefixSumStack.push(val + t.left.val);
            }else if (t.right != null && map.get(t.right) == null) {
                nodes.push(t.right);
                prefixSumStack.push(val + t.right.val);
            }else {
                nodes.pop();
                int ps = prefixSumStack.pop();
                Integer ps_count = prefixSumMap.get(ps);
                if (ps_count != null && ps_count != 0) {
                    prefixSumMap.put(ps, ps_count - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(10);
        TreeNode t12 = new TreeNode(5); t11.left = t12;
        TreeNode t13 = new TreeNode(-3); t11.right = t13;
        TreeNode t14 = new TreeNode(3); t12.left = t14;
        TreeNode t15 = new TreeNode(2); t12.right = t15;
        TreeNode t16 = new TreeNode(11); t13.right = t16;
        TreeNode t17 = new TreeNode(3); t14.left = t17;
        TreeNode t18 = new TreeNode(-2); t14.right = t18;
        TreeNode t19 = new TreeNode(1); t15.right = t19;

        TreeNode t21 = new TreeNode(1);

        _437_PathSumIII ps3 = new _437_PathSumIII();
        TreeNode t = t11;
        int sum = 8;
        System.out.println(ps3.pathSum(t, sum));
        System.out.println(ps3.pathSum_iterationTraversal(t, sum));
        System.out.println(ps3.pathSum_prefixSumRecursive(t, sum));
        System.out.println(ps3.pathSum_prefixSumIteration(t, sum));
    }
}
