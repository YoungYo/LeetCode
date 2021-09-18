package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-18 13:45:39
 * Title: 897. Increasing Order Search Tree
 * 中国站链接：https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 美国站链接：https://leetcode.com/problems/increasing-order-search-tree/
 */
public class _897_IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new _897_IncreasingOrderSearchTree().new Solution();
        Integer[][] inputs = {
				{5,1,7},
				{5,3,6,2,4,null,8,1,null,null,null,7,9}
		};
        for (Integer[] input: inputs) {
			for (int i = 0; i < input.length; i++) {
				System.out.print(i + "\t");
			}
			System.out.println();
        	for (Integer i: input) {
				System.out.print(i + "\t");
			}
			System.out.println();
			TreeNode treeNode = solution.increasingBST(BinaryTreeUtil.buildTree(input));
        	while (Objects.nonNull(treeNode)) {
				System.out.print(treeNode.val + "\t");
				treeNode = treeNode.right;
			}
			System.out.println();
			System.out.println();
			int a = 0;
		}
    }
	class Solution {
    	private TreeNode resNode;
	    public TreeNode increasingBST(TreeNode root) {
	    	TreeNode resultPre = new TreeNode();
	    	resNode = resultPre;
	    	inOrder(root);
			return resultPre.right;
		}

		private void inOrder(TreeNode root) {
	    	if (Objects.isNull(root)) {
	    		return;
			}
	    	inOrder(root.left);
	    	resNode.right = root;
	    	root.left = null;
	    	resNode = root;
	    	inOrder(root.right);
		}
	}
}
