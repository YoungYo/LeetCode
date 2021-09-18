package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-18 13:01:01
 * Title: 617. Merge Two Binary Trees
 * 中国站链接：https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 美国站链接：https://leetcode.com/problems/merge-two-binary-trees/
 */
public class _617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new _617_MergeTwoBinaryTrees().new Solution();
        Integer[][][] inputs = {
				{{1}, {1, 2}},
				{{1,3,2,5}, {2,1,3,null,4,null,7}},
		};
        for (Integer[][] input: inputs) {
			TreeNode root = solution.mergeTrees(BinaryTreeUtil.buildTree(input[0]), BinaryTreeUtil.buildTree(input[1]));
			int a = 0;
		}
    }

	class Solution {
	    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
			if (Objects.isNull(root1) && Objects.isNull(root2)) {
				return null;
			}
			if (Objects.isNull(root1)) {
				return root2;
			}
			if (Objects.isNull(root2)) {
				return root1;
			}
			TreeNode root = new TreeNode(root1.val + root2.val);
			root.left = mergeTrees(root1.left, root2.left);
			root.right = mergeTrees(root1.right, root2.right);
			return root;
		}
	}
}
