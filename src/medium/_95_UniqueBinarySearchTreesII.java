package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王浩
 * @date 2021-09-15 09:52:20
 * 中国站链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 美国站链接：https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class _95_UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        Solution solution = new _95_UniqueBinarySearchTreesII().new Solution();
		List<TreeNode> roots = solution.generateTrees(8);
//		for (TreeNode root: roots) {
//			System.out.println(BinaryTreeUtil.binaryTreeToList(root).toString());
//		}
		int a = 0;
	}
	class Solution {
		private List<TreeNode>[][] memorandum;
	    public List<TreeNode> generateTrees(int n) {
	    	memorandum = new List[n + 1][n + 1];
	    	generateTree(1, n);
	    	return memorandum[1][n];
	    }

	    private void generateTree(int low, int high) {
	    	if (memorandum[low][high] != null && memorandum[low][high].size() > 0) {
	    		return;
			}
	    	if (memorandum[low][high] == null) {
	    		memorandum[low][high] = new LinkedList<>();
			}
	    	List<TreeNode> currentRecord = memorandum[low][high];
			if (low > high) {
				currentRecord.add(null);
				return;
			}
			if (low == high) {
	    		currentRecord.add(new TreeNode(low));
	    		return;
			}
			for (int i = low; i < high; i++) {
				generateTree(low, i - 1);
				generateTree(i + 1, high);
				List<TreeNode> rightChildList = memorandum[i + 1][high];
				List<TreeNode> leftChildList = memorandum[low][i - 1];
				for (int j = 0; j < rightChildList.size(); j++) {
					for (int k = 0; k < leftChildList.size(); k++) {
						TreeNode root = new TreeNode(i);
						root.right = rightChildList.get(j);
						root.left = leftChildList.get(k);
						currentRecord.add(root);
					}
				}
			}
			generateTree(low, high - 1);
			List<TreeNode> leftChildList = memorandum[low][high - 1];
			for (int k = 0; k < leftChildList.size(); k++) {
				TreeNode root = new TreeNode(high);
				root.left = leftChildList.get(k);
				currentRecord.add(root);
			}
		}
	}
}
