package medium;

import util.TreeNode;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal_Array {
    private int[] inorderMap; //记录中序遍历序列中结点的值与该节点在序列中的位置的映射关系
    private int[] preorder;
    private int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int nodeCount = preorder.length; //二叉树结点的个数
        if (nodeCount == 0){
            return null;
        }
        for(int val : preorder){
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
        }
        inorderMap = new int[maxVal - minVal + 1];
        for (int i = 0; i < nodeCount; i++) {
            inorderMap[inorder[i] - minVal] = i;
        }
        return build(0, 0, nodeCount);
    }

    public TreeNode build(int preLb, int inLb, int inRb){
        if (inLb == inRb){
            return null;
        }
        int rootVal = preorder[preLb]; //根节点的值
        TreeNode root = new TreeNode(rootVal);
        int offset = rootVal - minVal;
        int offsetIdxInInoder = inorderMap[offset]; //根节点的值在中序遍历序列中的位置
        int lNodeCount = offsetIdxInInoder - inLb; //左子树结点的个数

        TreeNode lc = build(preLb + 1, inLb, inorderMap[offset]);
        TreeNode rc = build(preLb + lNodeCount + 1, inorderMap[offset] + 1, inRb);
        root.left = lc;
        root.right = rc;
        return root;
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTreefromPreorderandInorderTraversal_Array cbtpit = new _105_ConstructBinaryTreefromPreorderandInorderTraversal_Array();
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder1 = {9,3,15,20,7};
        int[] testpreorder = preorder1, testinorder = inorder1;
        TreeNode root = cbtpit.buildTree(testpreorder, testinorder);
        int a = 0;
    }
}
