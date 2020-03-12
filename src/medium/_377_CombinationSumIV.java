package medium;

import java.util.Arrays;

public class _377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
//        Arrays.sort(nums);
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    res[i] += res[i - nums[j]];
                }
            }
        }
        return res[target];
    }

    public static void main(String[] args) {
        _377_CombinationSumIV cs4 = new _377_CombinationSumIV();
        int[] nums1 = {1,2,3};
        int target1 = 4;

        int[] nums2 = {2,1,3};
        int target2 = 35;

        int[] nums = nums1;
        int target = target1;

        System.out.println(cs4.combinationSum4(nums, target));
    }
}
