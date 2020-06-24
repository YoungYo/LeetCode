package easy;

import util.TreeNode;

public class _108_ConvertSortedArraytoBinarySearchTree {
    int[] myNums;
    public TreeNode sortedArrayToBST(int[] nums) {
        myNums = nums;
        return buildBST(0, nums.length);
    }

    public TreeNode buildBST(int low, int high) {
        if (low >= high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(myNums[mid]);
        root.left = buildBST(low, mid);
        root.right = buildBST(mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        _108_ConvertSortedArraytoBinarySearchTree convert = new _108_ConvertSortedArraytoBinarySearchTree();
        int[][] test = {
                {-10,-3,0,5,9}
        };
        for (int[] nums : test) {
            TreeNode t = convert.sortedArrayToBST(nums);
            int a = 0;
//            System.out.println(convert.sortedArrayToBST(nums));
        }
    }
}
