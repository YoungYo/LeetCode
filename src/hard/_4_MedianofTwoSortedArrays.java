package hard;

public class _4_MedianofTwoSortedArrays {
    public static double findMedianSortedArrays_recursive(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //处理任何一个nums为空数组的情况
        if (m == 0) {
            if (n % 2 != 0)
                return 1.0 * nums2[n / 2];
            return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }
        if (n == 0) {
            if (m % 2 != 0)
                return 1.0 * nums1[m / 2];
            return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }
        int total = m + n;
        //总数为奇数，找第 total / 2 + 1 个数
        if ((total & 1) == 1) {
            return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
        }
        //总数为偶数，找第 total / 2 个数和第total / 2 + 1个数的平均值
        return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;

    }

    //寻找a 和 b 数组中，第k个数字
    public static double find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
        //当a 或 b 超过数组长度，则第k个数为另外一个数组第k个数
        if (a_begin >= a.length)
            return b[b_begin + k - 1];
        if (b_begin >= b.length)
            return a[a_begin + k - 1];
        //k为1时，两数组最小的那个为第一个数
        if (k == 1)
            return Math.min(a[a_begin], b[b_begin]);

        int mid_a = Integer.MAX_VALUE;
        int mid_b = Integer.MAX_VALUE;
        //mid_a / mid_b 分别表示 a数组、b数组中第 k / 2 个数
        if (a_begin + k / 2 - 1 < a.length)
            mid_a = a[a_begin + k / 2 - 1];
        if (b_begin + k / 2 - 1 < b.length)
            mid_b = b[b_begin + k / 2 - 1];
        //如果a数组的第 k / 2 个数小于b数组的第 k / 2 个数，表示总的第 k 个数位于 a的第k / 2个数的后半段，或者是b的第 k / 2个数的前半段
        //由于范围缩小了 k / 2 个数，此时总的第 k 个数实际上等于新的范围内的第 k - k / 2个数，依次递归
        if (mid_a < mid_b)
            return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
        //否则相反
        return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            return helper1(nums2);
        }
        if (nums2 == null || nums2.length == 0){
            return helper1(nums1);
        }
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        if (nums1[nums1_len - 1] <= nums2[0]){
            return helper(nums1, nums2);
        }else if (nums2[nums2_len - 1] <= nums1[0]){
            return helper(nums2, nums1);
        }
        int totallen = nums1_len + nums2_len;
        int idx = totallen / 2;
        double pre_res = 0, res = 0;
        for (int i = 0, j = 0, k = 0; (i < nums1_len || j < nums2_len) && k <= idx; k++) {
            pre_res = res;
            if (i < nums1_len && j < nums2_len){
                if (nums1[i] <= nums2[j]){
                    res = nums1[i++];
                }else {
                    res = nums2[j++];
                }
            }else if (i < nums1_len){
                res = nums1[i++];
            }else if (j < nums2_len){
                res = nums2[j++];
            }
        }
        if ((totallen & 1) == 1)
            return res;
        else
            return (pre_res + res) / 2.0;
    }

    public static double helper1(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int idx = len / 2;
        if ((len & 1) == 1)
            return nums[idx];
        else
            return (nums[idx] + nums[idx - 1]) / 2.0;
    }

    public static double helper(int[] left, int[] right){
        int left_len = left.length;
        int right_len = right.length;
        int totallen = left_len + right_len;
        int idx = totallen / 2;
        if (idx < left_len){
            if ((totallen & 1) == 1)
                return left[idx];
            else
                return (left[idx] + left[idx - 1]) / 2.0;
        }else if (idx == left_len){
            if ((totallen & 1) == 1)
                return right[0];
            else
                return (left[left_len - 1] + right[0]) / 2.0;
        }else {
            if ((totallen & 1) == 1)
                return right[idx - left_len];
            else
                return (right[idx - left_len - 1] + right[idx - left_len]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }
}
