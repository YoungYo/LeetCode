//Given the root of a binary tree, imagine yourself standing on the right side o
//f it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 4263 👎 229

  
package leetcode.editor.en;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2); t1.left = t2;
        TreeNode t3 = new TreeNode(3); t1.right = t3;
        TreeNode t4 = new TreeNode(4); t3.right = t4;
        TreeNode t5 = new TreeNode(5); t2.right = t5;
        solution.rightSideView(t1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
/*
        public List<Integer> rightSideView(TreeNode root) {
            if (Objects.isNull(root)) {
                return new ArrayList<>();
            }
            List<Integer> rightResult = rightSideView(root.right);
            List<Integer> leftResult = rightSideView(root.left);
            ArrayList<Integer> result = new ArrayList<>(Math.max(rightResult.size(), leftResult.size()) + 1);
            result.add(root.val);
            int i = 0;
            for (; i < rightResult.size(); i++) {
                result.add(rightResult.get(i));
            }
            for (; i < leftResult.size(); i++) {
                result.add(leftResult.get(i));
            }
            return result;
        }
*/
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            if (Objects.isNull(root)) {
                return result;
            }
            LinkedList<TreeNode> levelA = new LinkedList<>(), levelB = new LinkedList<>();
            levelA.addFirst(root);
            while (!levelA.isEmpty()) {
                TreeNode treeNode = levelA.removeLast();
                if (Objects.nonNull(treeNode.left)) {
                    levelB.addFirst(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    levelB.addFirst(treeNode.right);
                }
                if (levelA.isEmpty()) {
                    result.add(treeNode.val);
                    LinkedList<TreeNode> tempList = levelB;
                    levelB = levelA;
                    levelA = tempList;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}