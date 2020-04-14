package medium;

import util.TreeNode;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal_Fastest {
    int i, j;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return backTrace(preorder, inorder, Long.MIN_VALUE);
    }

    private TreeNode backTrace(int[] preorder, int[] inorder, long min) {
        if (i >= preorder.length) return null;
        if (inorder[j] == min) {
            j++;
            return null;
        }

        TreeNode curr = new TreeNode(preorder[i++]);
        curr.left = backTrace(preorder, inorder, curr.val);
        curr.right = backTrace(preorder, inorder, min);

        return curr;
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTreefromPreorderandInorderTraversal_Fastest cbtpit = new _105_ConstructBinaryTreefromPreorderandInorderTraversal_Fastest();
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder1 = {9,3,15,20,7};
        int[] testpreorder = preorder1, testinorder = inorder1;
        TreeNode root = cbtpit.buildTree(testpreorder, testinorder);
        int a = 0;
    }
}
