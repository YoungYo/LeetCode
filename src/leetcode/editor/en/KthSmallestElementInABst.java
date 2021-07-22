//Given the root of a binary search tree, and an integer k, return the kth (1-in
//dexed) smallest element in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//Follow up: If the BST is modified often (i.e., we can do insert and delete ope
//rations) and you need to find the kth smallest frequently, how would you optimiz
//e? Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 4351 👎 93

  
package leetcode.editor.en;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        Integer[][] inputs = {
                {3,1,4,null,2},
                {5,3,6,2,4,null,null,1}
        };
        Integer[] input = inputs[1];
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
        System.out.println(solution.kthSmallest(root, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
    // 递归实现
    class Solution {
        private int n = 0;
        private int k;
        private int result = 0;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            inOrderTraverse(root);
            return result;
        }

        private void inOrderTraverse(TreeNode root) {
            if (n >= k) {
                return;
            }
            if (Objects.nonNull(root.left)) {
                inOrderTraverse(root.left);
            }
//            System.out.println(root.val);
            n++;
            if (n == k) {
                result = root.val;
            }
            if (Objects.nonNull(root.right)) {
                inOrderTraverse(root.right);
            }
        }
    }
*/

    // 迭代遍历实现
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode x = root;
            int n = 0, result = 0;
            while (true) {
                if (Objects.nonNull(x)) {
                    stack.push(x);
                    x = x.left;
                } else if (!stack.isEmpty()) {
                    x = stack.pop();
                    n++;
                    if (n == k) {
                        result = x.val;
                        break;
                    }
                    x = x.right;
                } else {
                    break;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}