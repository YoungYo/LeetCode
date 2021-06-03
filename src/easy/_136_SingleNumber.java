package easy;

/**
 * @author 王浩
 * @date 2021/6/3 上午9:35
 */
public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        _136_SingleNumber singleNumber = new _136_SingleNumber();
        int[][] nums = {
                {2, 2, 1},
                {4, 1, 2, 1, 2},
                {1}
        };
        for (int[] num : nums) {
            System.out.println(singleNumber.singleNumber(num));
        }
    }
}
