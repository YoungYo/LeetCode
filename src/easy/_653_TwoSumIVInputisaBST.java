package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 王浩
 * @date 2021-09-24 09:43:58
 * Title: 653. Two Sum IV - Input is a BST
 * 中国站链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 美国站链接：https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class _653_TwoSumIVInputisaBST {
    public static void main(String[] args) {
        Integer[][][] inputs = {
				{{5,3,6,2,4,null,7}, {28}},
				{{5,3,6,2,4,null,7}, {9}},
				{{2, 1, 3}, {4}},
				{{2, 1, 3}, {1}},
				{{2, 1, 3}, {3}},
		};
        for (Integer[][] input: inputs) {
			Solution solution = new _653_TwoSumIVInputisaBST().new Solution();
			System.out.println(solution.findTarget(BinaryTreeUtil.buildTree(input[0]), input[1][0]));
		}
    }

	class Solution {
    	private Set<Integer> haveVisitedValue = new HashSet<>();
    	private boolean result = false;
    	private int target;
	    public boolean findTarget(TreeNode root, int k) {
	    	target = k;
	    	preOrder(root);
	    	return result;
	    }

	    private void preOrder(TreeNode root) {
	    	if (haveVisitedValue.contains(target - root.val)) {
	    		result = true;
	    		return;
			}
	    	haveVisitedValue.add(root.val);
			if (Objects.nonNull(root.left)) {
				preOrder(root.left);
			}
			if (Objects.nonNull(root.right)) {
				preOrder(root.right);
			}
		}
	}
}
