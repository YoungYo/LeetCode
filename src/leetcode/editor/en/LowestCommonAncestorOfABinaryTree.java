//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 105]. 
// -109 <= Node.val <= 109 
// All Node.val are unique. 
// p != q 
// p and q will exist in the tree. 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 6680 👎 220

  
package leetcode.editor.en;

import util.TreeNode;

import java.util.Objects;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        Integer[][] treeNodes = {
                {3,5,1,6,2,0,8,null,null,7,4},
                {3,5,1,6,2,0,8,null,null,7,4},
                {1,2}
        };
        Integer[] input = treeNodes[1];
        TreeNode[] nodes = new TreeNode[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            if (Objects.nonNull(input[i])) {
                nodes[i] = new TreeNode(input[i]);
                if (2 * i + 1 < input.length) {
                    nodes[i].left = nodes[2 * i + 1];
                }
                if (2 * i + 2 < input.length) {
                    nodes[i].right = nodes[2 * i + 2];
                }
            }
        }
        TreeNode root = null;
        if (input.length > 0) {
            root = nodes[0];
        }
        System.out.println(solution.lowestCommonAncestor(root, nodes[1], nodes[10]).val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode p, q, result = null, childP = null, childQ = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;
            afterOrder(root);
            return result;
        }

        public void afterOrder(TreeNode root) {
            if (Objects.nonNull(result)) {
                return;
            }
            if (Objects.equals(root, this.p)) {
                this.childP = root;
                return;
            }
            if (Objects.equals(root, this.q)) {
                this.childQ = root;
                return;
            }
            if (root.left != null) {
                afterOrder(root.left);
            }
            if (root.right != null) {
                afterOrder(root.right);
            }
            if (this.childP != null && this.childQ != null) {
                this.result = root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}