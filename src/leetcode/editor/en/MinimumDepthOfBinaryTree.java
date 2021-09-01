//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁵]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 29
//37 👎 858

  
package leetcode.editor.en;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
         Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            if (Objects.isNull(root)) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>(), levelQueue = new LinkedList<>();
            queue.offer(root);
            int minDepth = 0;
            while (!queue.isEmpty()) {
                minDepth++;
                while (!queue.isEmpty()) {
                    TreeNode treeNode = queue.poll();
                    if (Objects.isNull(treeNode.right) && Objects.isNull(treeNode.left)) {
                        return minDepth;
                    } else {
                        if (Objects.nonNull(treeNode.right)) {
                            levelQueue.offer(treeNode.right);
                        }
                        if (Objects.nonNull(treeNode.left)) {
                            levelQueue.offer(treeNode.left);
                        }
                    }
                }
                Queue<TreeNode> temp = queue;
                queue = levelQueue;
                levelQueue = temp;
            }
            return minDepth;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}