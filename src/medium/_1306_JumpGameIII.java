package medium;

import java.util.LinkedList;
import java.util.Queue;

public class _1306_JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int i = queue.poll();
            if (arr[i] == 0){
                return true;
            }
            int forward = i + arr[i];
            if (forward < len && !visited[forward]){
                visited[forward] = true;
                queue.offer(forward);
            }
            int backward = i - arr[i];
            if (backward >= 0 && !visited[backward]){
                visited[backward] = true;
                queue.offer(backward);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _1306_JumpGameIII jg3 = new _1306_JumpGameIII();
        int[] arr1 = {4,2,3,0,3,1,2};
        int[] arr2 = {3,0,2,1,2};
        int[] arr = arr2;
        int start = 2;
        System.out.println(jg3.canReach(arr, start));
    }
}
