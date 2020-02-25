package easy;

public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        _53_MaximumSubarray ms = new _53_MaximumSubarray();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-2,-1};
        System.out.println(ms.maxSubArray(nums2));
    }
}
