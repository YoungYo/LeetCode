package hard;

import java.util.Stack;

public class _42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0, maxLeft = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            int maxRight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }

    //利用栈存储右边高度最大的元素
    public int trap_stack(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0, maxLeft = height[0], maxRight = Integer.MIN_VALUE;
        Stack<Integer> maxRightStack = new Stack<>();
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] > maxRight){
                maxRightStack.push(i);
                maxRight = height[i];
            }
        }
        for (int i = 1; i < height.length - 1; i++) {
            int maxRightIdx = maxRightStack.peek();
            if (maxLeft <= height[i]){
                maxLeft = height[i];
                if (i == maxRightIdx){
                    maxRightStack.pop();
                }
                continue;
            }
            if (i < maxRightIdx){
                maxRight = height[maxRightIdx];
            }else if (i == maxRightIdx){
                maxRightStack.pop();
                continue;
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }

    //动态规划
    public int trap_dp(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0, len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        left_max[0] = height[0];
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }

    public int trap_stack2(int[] height){
        if (height == null || height.length == 0)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (stack.size() >= 2 && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                int leftBoundIdx = stack.peek();
                int leftBound = height[leftBoundIdx], distance = i - leftBoundIdx - 1;
                res += (Math.min(leftBound, height[i]) - height[top]) * distance;
            }
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    //双指针法
    public int trap_TwoPoints(int[] height){
        if (height == null || height.length == 0)
            return 0;
        int i = 0, j = height.length - 1;
        int maxLeft = 0, maxRight = 0, res = 0;
        while (i < j){
            if (height[i] > maxLeft){
                maxLeft = height[i];
            }
            if (height[j] > maxRight){
                maxRight = height[j];
            }
            if (maxLeft < maxRight){
                res += maxLeft - height[i];
                i++;
            }else {
                res += maxRight - height[j];
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        _42_TrappingRainWater rt = new _42_TrappingRainWater();
        System.out.println(rt.trap(height));
        System.out.println(rt.trap_stack(height));
        System.out.println(rt.trap_dp(height));
        System.out.println(rt.trap_stack2(height));
        System.out.println(rt.trap_TwoPoints(height));
    }
}
