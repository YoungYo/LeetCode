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

    public static void main(String[] args) {
        int[] intput1 = {2,3,1,1,4};
        int[] intput2 = {3,2,1,0,4};

        _55_JumpGame jg = new _55_JumpGame();
        System.out.println(jg.canJump(intput2));
    }
}
