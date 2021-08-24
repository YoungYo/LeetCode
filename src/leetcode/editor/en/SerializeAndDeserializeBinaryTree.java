//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design Bin
//ary Tree 
// 👍 4907 👎 216

  
package leetcode.editor.en;

import util.Array2BinaryTree;
import util.TreeNode;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
        TreeNode root = Array2BinaryTree.buildTree(new Integer[]{1,2,3,null,null,4,5});
//        TreeNode root = Array2BinaryTree.buildTree(new Integer[]{});
//        TreeNode root = Array2BinaryTree.buildTree(new Integer[]{1});
//        TreeNode root = Array2BinaryTree.buildTree(new Integer[]{1, 2});
//        TreeNode root = Array2BinaryTree.buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2});
        String serializedTree = solution.serialize(root);
        System.out.println(serializedTree);
        TreeNode deserializedRoot = solution.deserialize(serializedTree);
        int a = 0;
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "{}";
            }
            return "{" + root.val + "," + serialize(root.left) + "," + serialize(root.right) + "}";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int rootValue = 0;
            int rootValueIsNegative = 1;
            int i = 1;
            for (; i < data.length() - 1; i++) {
                char c = data.charAt(i);
                if (c == '-') {
                    rootValueIsNegative = -1;
                } else {
                    int cValue = c - '0';
                    if (cValue >= 0 && cValue <= 9) {
                        rootValue += cValue;
                        rootValue *= 10;
                    } else {
                        data = data.substring(i + 1, data.length() - 1);
                        rootValue = rootValue / 10 * rootValueIsNegative;
                        break;
                    }
                }
            }
            if (i == 1) {
                return null;
            }
            TreeNode root = new TreeNode(rootValue);
            String leftChildStr = "", rightChildStr = "";
            int sum = 0;
            for (i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                if (c == '{') {
                    sum -= 1;
                } else if (c == '}') {
                    sum += 1;
                }
                if (sum == 0) {
                    leftChildStr = data.substring(0, i + 1);
                    rightChildStr = data.substring(i + 2);
                    break;
                }
            }
            root.left = deserialize(leftChildStr);
            root.right = deserialize(rightChildStr);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

}