package medium;

import java.util.Arrays;

public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }

        int len = nums.length;
        int i = len - 1;
        while (i >= 1) { //找到右边第一个nums[i]，满足nums[i]>nums[i-1]
            if (nums[i] > nums[i - 1]){
                break;
            }
            i--;
        }

        if (i > 0){ //如果i>0，说明找到了；如果i=0，说明没找到，当前序列就是最大的，那么直接翻转就可以了
            int j = i + 1, minidx = i;
            while (j < len){ //找到nums[i-1]右边大于nums[i-1]的最小的数的最大的索引，记为minidx。
                if (nums[j] > nums[i - 1] && nums[j] <= nums[minidx]){
                    minidx = j;
                }
                j++;
            }
            //交换nums[i-1]和nums[minidx]
            nums[i - 1] = nums[i - 1] ^ nums[minidx];
            nums[minidx] = nums[i - 1] ^ nums[minidx];
            nums[i - 1] = nums[i - 1] ^ nums[minidx];
        }
        int k = len - 1;
        while (i < k){ //翻转nums[i..len-1]
            nums[i] = nums[i] ^ nums[k];
            nums[k] = nums[i] ^ nums[k];
            nums[i] = nums[i] ^ nums[k];
            i++;
            k--;
        }
    }

    public static void main(String[] args) {
        _31_NextPermutation np = new _31_NextPermutation();
        int[] nums1 = {1,2,3};
        int[] nums2 = {3,2,1};
        int[] nums3 = {1,1,5};
        int[] nums4 = {1,3,2};
        int[] nums5 = {2,3,1,3,3};
        int[] nums = nums5;
        np.nextPermutation(nums);
        for(int i: nums){
            System.out.printf("%d, ", i);
        }
    }
}
