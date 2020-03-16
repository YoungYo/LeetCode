package medium;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] res = new boolean[len];
        res[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (res[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j == len - 1) {
                        return true;
                    }
                    res[i + j] = true;
                }
            }else {
                return false;
            }
        }
        return res[len - 1];
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0 || (nums.length > 1 && nums[0] == 0)) return false;
        if (nums.length == 1) return true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i - 1;
                while (j >= 0) {
                    if (nums[j] > i - j) break;
                    j--;
                }
                if (j == -1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input1 = {2,3,1,1,4};
        int[] input2 = {3,2,1,0,4};
        int[] input3 = {2,5,0,0};

        _55_JumpGame jg = new _55_JumpGame();

        int[] input = input1;
        System.out.println(jg.canJump(input));
        System.out.println(jg.canJump2(input));
    }
}
