package hard;

import java.util.Arrays;

public class _45_JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int step = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd){
                step++;
                curEnd = curFarthest;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        _45_JumpGameII jg2 = new _45_JumpGameII();
        int[] input1 = {2,3,1,1,4};
        System.out.println(jg2.jump(input1));
    }
}
