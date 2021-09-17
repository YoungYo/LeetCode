package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-17 09:45:27
 * Title: Range Sum of BST
 * 中国站链接：https://leetcode-cn.com/problems/range-sum-of-bst/
 * 美国站链接：https://leetcode.com/problems/range-sum-of-bst/
 */
public class _938_RangeSumofBST {
    public static void main(String[] args) {
        Solution solution = new _938_RangeSumofBST().new Solution();
        Integer[][][] inputs = {
				{{10,5,15,3,7,null,18}, {7, 15}},
				{{10,5,15,3,7,13,18,1,null,6}, {6, 10}}
		};
        for (Integer[][] input: inputs) {
			System.out.println(solution.rangeSumBST(BinaryTreeUtil.buildTree(input[0]), input[1][0], input[1][1]));
		}
    }
	class Solution {
		public int rangeSumBST(TreeNode root, int low, int high) {
			int result = 0;
			int val = root.val;
			if (val >= low && val <= high) {
				result += val;
			}
			if (val > low && Objects.nonNull(root.left)) {
				result += rangeSumBST(root.left, low ,high);
			}
			if (val < high && Objects.nonNull(root.right)) {
				result += rangeSumBST(root.right, low, high);
			}
			return result;
		}
/*
	    public int rangeSumBST(TreeNode root, int low, int high) {
	    	if (Objects.isNull(root)) {
	    		return 0;
			}
			final int val = root.val;
			if (val < low) {
	    		return rangeSumBST(root.right, low, high);
			} else if (val == low) {
	    		return val + rangeSumBST(root.right, low, high);
			} else if (val < high) {
				return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
			} else if (val == high) {
				return val + rangeSumBST(root.left, low, high);
			} else {
				return rangeSumBST(root.left, low, high);
			}
		}
*/
	}
}
