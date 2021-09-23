package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author 王浩
 * @date 2021-09-23 09:29:50
 * Title: 637. Average of Levels in Binary Tree
 * 中国站链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 美国站链接：https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class _637_AverageofLevelsinBinaryTree {
    public static void main(String[] args) {
        Solution solution = new _637_AverageofLevelsinBinaryTree().new Solution();
        Integer[][] inputs = {
				{3,9,20,null,null,15,7},
				{3,9,20,15,7}
		};
        for (Integer[] input: inputs) {
			System.out.println(solution.averageOfLevels(BinaryTreeUtil.buildTree(input)));
		}
    }
	class Solution {
	    public List<Double> averageOfLevels(TreeNode root) {
	    	List<Double> result = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			if (Objects.nonNull(root)) {
				queue.offer(root);
			}
			while (!queue.isEmpty()) {
				int size = queue.size();
				long sum = 0;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					sum += node.val;
					if (Objects.nonNull(node.left)) {
						queue.offer(node.left);
					}
					if (Objects.nonNull(node.right)) {
						queue.offer(node.right);
					}
				}
				result.add(sum * 1.0 / size);
			}
			return result;
	    }
	}
}
