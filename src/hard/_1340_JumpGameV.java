package hard;

import java.util.HashMap;

public class _1340_JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        int[] memo = new int[len];
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dfs(arr, d, i, memo));
        }
        return res;
    }

    private int dfs(int[] arr, int d, int start, int[] memo){
        int maxAtStart = memo[start];
        if (maxAtStart != 0) {
            return maxAtStart;
        }
        maxAtStart = 1;
        for (int i = 1; i <= d; i++) {
            int forward = start + i;
            if (forward < arr.length && arr[forward] < arr[start]){
                maxAtStart = Math.max(maxAtStart, dfs(arr, d, forward, memo) + 1);
            }else
                break;
        }
        for (int i = 1; i <= d; i++) {
            int backward = start - i;
            if (backward >= 0 && arr[backward] < arr[start]){
                maxAtStart = Math.max(maxAtStart, dfs(arr, d, backward, memo) + 1);
            }else
                break;
        }
        memo[start] = maxAtStart;
        return maxAtStart;
    }

    public static void main(String[] args) {
        _1340_JumpGameV jg5 = new _1340_JumpGameV();
        int[] arr1 = {6,4,14,6,8,13,9,7,10,6,12};
        int d1 = 2 ;

        int[] arr = arr1;
        int d = d1;

        System.out.println(jg5.maxJumps(arr, d));
    }
}
