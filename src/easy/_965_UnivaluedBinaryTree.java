package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-23 09:12:46
 * Title: 965. Univalued Binary Tree
 * 中国站链接：https://leetcode-cn.com/problems/univalued-binary-tree/
 * 美国站链接：https://leetcode.com/problems/univalued-binary-tree/
 */
public class _965_UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new _965_UnivaluedBinaryTree().new Solution();
        Integer[][] inputs = {
				{1,1,1,1,1,null,1},
				{2,2,2,5,2}
		};
        for (Integer[] input: inputs) {
			System.out.println(solution.isUnivalTree(BinaryTreeUtil.buildTree(input)));
		}
    }
	class Solution {
	    public boolean isUnivalTree(TreeNode root) {
	    	return isUnivalTreeWithValue(root, root.val);
	    }

	    private boolean isUnivalTreeWithValue(TreeNode root, int value) {
	    	if (Objects.isNull(root)) {
	    		return true;
			}
	    	if (root.val != value) {
	    		return false;
			}
	    	if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
	    		return true;
			}
	    	return isUnivalTreeWithValue(root.left, value) && isUnivalTreeWithValue(root.right, value);
		}
	}
}
