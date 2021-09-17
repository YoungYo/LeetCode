package medium;

import util.BinaryTreeUtil;
import util.TreeNode;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021/9/9 1:05 下午
 */
public class _450_DeleteNodeinaBST {
    public static void main(String[] args) {
        Solution solution = new _450_DeleteNodeinaBST().new Solution();
        Integer[][][] inputs = {
                {{50,30,70,null,40,60,80}, {50}},
                {{5,3,6,2,4,null,7}, {3}},
                {{5,3,6,2,4,null,7}, {0}},
                {{}, {0}}
        };
        for (Integer[][] input: inputs) {
            TreeNode root = solution.deleteNode(BinaryTreeUtil.buildTree(input[0]), input[1][0]);
            int a = 0;
        }
    }
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (Objects.isNull(root)) {
                return null;
            }
            if (root.val == key) {
                if (Objects.nonNull(root.right)) {
                    TreeNode leftBound = findLeftBound(root.right);
                    root.right = deleteNode(root.right, leftBound.val);
                    leftBound.left = root.left;
                    leftBound.right = root.right;
                    root.left = null;
                    root.right = null;
                    return leftBound;
                } else if (Objects.nonNull(root.left)) {
                    TreeNode rightBound = findRightBound(root.left);
                    root.left = deleteNode(root.left, rightBound.val);
                    rightBound.left = root.left;
                    rightBound.right = root.right;
                    root.left = null;
                    root.right = null;
                    return rightBound;
                } else {
                    return null;
                }
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }

        private TreeNode findLeftBound(TreeNode root) {
            while (Objects.nonNull(root.left)) {
                root = root.left;
            }
            return root;
        }

        private TreeNode findRightBound(TreeNode root) {
            while (Objects.nonNull(root.right)) {
                root = root.right;
            }
            return root;
        }
    }
}
