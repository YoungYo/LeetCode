package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1345_JumpGameIV {
    public int minJumps(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Queue<Integer>> map = new HashMap<>((int)(len / 0.75));
        for (int i = 0; i < len; i++) {
            Queue<Integer> queue = map.computeIfAbsent(arr[i], k -> new LinkedList<>());
            queue.offer(i);
        }
        Queue<Integer> idxQueue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        int step = 0;
        idxQueue.offer(0);
        visited[0] = true;
        out: while (!idxQueue.isEmpty()){
            Queue<Integer> q = new LinkedList<>(idxQueue);
            idxQueue.clear();
            while (!q.isEmpty()){
                int idx = q.poll();
                if (idx == len - 1){
                    break out;
                }
                if (idx + 1 < len && !visited[idx + 1]){
                    idxQueue.offer(idx + 1);
                    visited[idx + 1] = true;
                }
                if (idx - 1 >= 0 && !visited[idx - 1]){
                    idxQueue.offer(idx - 1);
                    visited[idx - 1] = true;
                }
                Queue<Integer> sameValue = map.get(arr[idx]);
                if (sameValue != null ){
                    while (!sameValue.isEmpty()){
                        int svidx = sameValue.poll();
                        if (!visited[svidx]){
                            idxQueue.offer(svidx);
                            visited[svidx] = true;
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        _1345_JumpGameIV jg4 = new _1345_JumpGameIV();

        int[] arr1 = {100,-23,-23,404,100,23,23,23,3,404};
        int[] arr2 = {7};
        int[] arr3 = {7,6,9,6,9,6,9,7};
        int[] arr4 = {6,1,9};
        int[] arr5 = {11,22,7,7,7,7,7,7,7,22,13};
        System.out.println(jg4.minJumps(arr5));
    }
}
