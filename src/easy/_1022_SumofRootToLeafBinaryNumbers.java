package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-22 09:47:25
 * Title: 1022. Sum of Root To Leaf Binary Numbers
 * 中国站链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * 美国站链接：https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class _1022_SumofRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Integer[][] inputs = {
				{1,0,1,0,1,0,1},
				{0},
				{1},
				{1,1}
		};
        for (Integer[] input: inputs) {
			Solution solution = new _1022_SumofRootToLeafBinaryNumbers().new Solution();
			System.out.println(solution.sumRootToLeaf(BinaryTreeUtil.buildTree(input)));
		}
    }

	class Solution {
    	private int sum = 0;
	    public int sumRootToLeaf(TreeNode root) {
	    	sumToLeaf(root, 0);
	    	return sum;
	    }

	    public void sumToLeaf(TreeNode node, int parentNum) {
	    	if (Objects.isNull(node)) {
	    		return;
			}
	    	if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
	    		sum += ((parentNum << 1) + node.val);
	    		return;
			}
	    	parentNum = ((parentNum << 1) + node.val);
	    	if (Objects.nonNull(node.left)) {
	    		sumToLeaf(node.left, parentNum);
			}
			if (Objects.nonNull(node.right)) {
				sumToLeaf(node.right, parentNum);
			}
		}
	}
}
