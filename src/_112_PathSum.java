import java.util.Stack;

public class _112_PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int val = root.val;
        if (root.left == null && root.right == null && val == sum)
            return true;
        return hasPathSum(root.left, sum - val) || hasPathSum(root.right, sum - val);
    }

    public static boolean hasPathSum_iteration(TreeNode root, int sum){
        if (root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> path = new Stack<>();

        TreeNode t = root;
        Integer val = root.val;
        stack.push(t);
        path.push(val);
        while (!stack.isEmpty()){
            t = stack.pop();
            val = path.pop();
            if (t.left == null && t.right == null && sum == val){ //到达了叶子结点，且路径总和正好等于sum
                return true;
            }
            if (t.left != null){
                stack.push(t.left);
                path.push(val + t.left.val);
            }
            if (t.right != null){
                stack.push(t.right);
                path.push(val + t.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7); t1.left = t2; t1.right = t3;
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3); t2.left = t4; t2.right = t5;
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9); t3.left = t6; t3.right = t7;

        TreeNode t21 = new TreeNode(1);
        t21.left = new TreeNode(2);

        System.out.println(hasPathSum_iteration(t1, 7));
        System.out.println(hasPathSum(t1, 7));
    }
}
