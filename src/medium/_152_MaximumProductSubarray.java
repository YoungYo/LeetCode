package medium;

public class _152_MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            if (cur < 0){
                imax = imax ^ imin;
                imin = imax ^ imin;
                imax = imax ^ imin;
            }
            imax = Math.max(imax * cur, cur);
            imin = Math.min(imin * cur, cur);
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input1 = {2,3,-2,4};
        int[] input2 = {-2,0,-1};

        System.out.println(maxProduct(input2));
    }
}
