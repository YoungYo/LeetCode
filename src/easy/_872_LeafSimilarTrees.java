package easy;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-09-24 09:27:57
 * Title: 872. Leaf-Similar Trees
 * 中国站链接：https://leetcode-cn.com/problems/leaf-similar-trees/
 * 美国站链接：https://leetcode.com/problems/leaf-similar-trees/
 */
public class _872_LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new _872_LeafSimilarTrees().new Solution();
        Integer[][][] inputs = {
				{{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}, {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}},
				{{1}, {1}},
				{{1}, {2}},
				{{1, 2}, {2, 2}},
				{{1, 2, 3}, {1, 3, 2}},
		};
        for (Integer[][] input: inputs) {
			System.out.println(solution.leafSimilar(BinaryTreeUtil.buildTree(input[0]), BinaryTreeUtil.buildTree(input[1])));
		}
    }

	class Solution {
		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			List<Integer> leafValueList1 = new LinkedList<>();
			List<Integer> leafValueList2 = new LinkedList<>();
			getLeafValueList(root1, leafValueList1);
			getLeafValueList(root2, leafValueList2);
			if (leafValueList1.size() != leafValueList2.size()) {
				return false;
			}
			for (int i = 0; i < leafValueList1.size(); i++) {
				if (!Objects.equals(leafValueList1.get(i), leafValueList2.get(i))) {
					return false;
				}
			}
			return true;
		}

	    public void getLeafValueList(TreeNode root, List<Integer> leafValueList) {
			if (Objects.isNull(root)) {
				return;
			} else if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
				leafValueList.add(root.val);
				return;
			}
			if (Objects.nonNull(root.left)) {
				getLeafValueList(root.left, leafValueList);
			}
			if (Objects.nonNull(root.right)) {
				getLeafValueList(root.right, leafValueList);
			}
		}
	}
}
