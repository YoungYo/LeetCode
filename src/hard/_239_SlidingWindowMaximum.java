package hard;

import java.util.*;

public class _239_SlidingWindowMaximum {
    /** 利用优先级队列实现 */
    public static int[] maxSlidingWindow_priorityqueue(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = 1; i + k <= len; i++) {
            queue.remove(nums[i - 1]);
            queue.add(nums[i + k - 1]);
            res[i] = queue.peek();
        }
        return res;
    }

    /** 利用双端队列实现 */
    public static int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int ri = 0;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1){
                res[ri++] = nums[deque.peek()];
            }
        }
        return res;
    }

    /** 先从左往右扫描数组，再从右往左扫描数组 */
    public static int[] maxSlidingWindow_scan(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int[] left = new int[len]; left[0] = nums[0];
        int[] right = new int[len]; right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = (i % k == 0) ? nums[i] : Math.max(left[i - 1], nums[i]);
            int j = len - i - 1;
            right[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
        }

        for (int i = 0, j = 0; i + k <= len; i++) {
            res[j++] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }

    public static int[] maxSlidingWindow_fastest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int MAX = -1;
        for (int left = 0, right = k - 1; right < len; left++, right++) {
            if (MAX < left){
                MAX = left;
                for (int i = left; i <= right; i++) {
                    if (nums[i] > nums[MAX]){
                        MAX = i;
                    }
                }
            }else if (nums[MAX] < nums[right]){
                MAX = right;
            }
            res[left] = nums[MAX];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] input = {1, 3, -1, -3, 5, 3, 6, 7, 8};
        int[] input = {2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56};
//        int[] input = {1, 3, -1};
//        int[] input = {1, -1};
//        int[] input = {7, 2, 4};
//        int[] input = {};
//        int[] input = {1, 3, 1, 2, 0, 5};
        int[] res_priorityqueue = maxSlidingWindow_priorityqueue(input, 3);
        for (int i : res_priorityqueue) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] res_deque = maxSlidingWindow_deque(input, 3);
        for (int i : res_deque) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] res_scan = maxSlidingWindow_scan(input, 3);
        for (int i : res_scan) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] res_fastest = maxSlidingWindow_fastest(input, 3);
        for (int i : res_fastest) {
            System.out.print(i + ",");
        }
    }
}
