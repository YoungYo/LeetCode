package medium;

import util.TreeNode;
import java.util.HashMap;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    private HashMap<Integer, Integer> inorderMap; //记录中序遍历序列中结点的值与该节点在序列中的位置的映射关系
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int nodeCount = preorder.length; //二叉树结点的个数
        inorderMap = new HashMap<>(nodeCount);
        for (int i = 0; i < nodeCount; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(0, 0, nodeCount);
    }

    public TreeNode build(int preLb, int inLb, int inRb){
        if (inLb == inRb){
            return null;
        }
        int rootVal = preorder[preLb]; //根节点的值
        TreeNode root = new TreeNode(rootVal);
        int rootValIdxInInoder = inorderMap.get(rootVal); //根节点的值在中序遍历序列中的位置
        int lNodeCount = rootValIdxInInoder - inLb; //左子树结点的个数

        TreeNode lc = build(preLb + 1, inLb, inorderMap.get(rootVal));
        TreeNode rc = build(preLb + lNodeCount + 1, inorderMap.get(rootVal) + 1, inRb);
        root.left = lc;
        root.right = rc;
        return root;
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTreefromPreorderandInorderTraversal cbtpit = new _105_ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder1 = {9,3,15,20,7};
        int[] testpreorder = preorder1, testinorder = inorder1;
        TreeNode root = cbtpit.buildTree(testpreorder, testinorder);
        int a = 0;
    }
}
