package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author 王浩
 * @date 2021/8/24 12:33 上午
 */
public class BinaryTreeUtil {

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < nodes.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i]);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            int leftIndex = 2 * i + 1;
            if (leftIndex < nodes.length) {
                nodes[i].left = nodes[leftIndex];
            }
            int rightIndex = 2 * i + 2;
            if (rightIndex < values.length) {
                nodes[i].right = nodes[rightIndex];
            }
        }
        return nodes[0];
    }

    public static List<Integer> binaryTreeToList(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.nonNull(node)) {
                result.add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            } else {
                result.add(null);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] input = {1,2,3,null,null,4,5};
        TreeNode tree = buildTree(input);
        int a = 0;
    }
}
