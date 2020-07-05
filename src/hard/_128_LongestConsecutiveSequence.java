package hard;

import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int current_num = num;
                int length = 1;
                while (set.contains(current_num + 1)) {
                    length++;
                    current_num++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _128_LongestConsecutiveSequence longestConsecutiveSequence = new _128_LongestConsecutiveSequence();
        int[][] test = {
                {100, 4, 200, 1, 3, 2},
                {}
        };
        for (int[] nums: test) {
            System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
        }
    }
}
