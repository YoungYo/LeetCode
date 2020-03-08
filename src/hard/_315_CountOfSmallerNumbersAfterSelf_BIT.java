package hard;

import java.util.*;

public class _315_CountOfSmallerNumbersAfterSelf_BIT {
    public static int[] bit;

    public static List<Integer> countSmaller(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] res = new Integer[nums.length];
        for (int i: nums) {
            set.add(i);
        }
        bit = new int[set.size() + 1];
        Object[] sorted = set.toArray();
        Arrays.sort(sorted);
        for(Object obj: sorted){
            map.put((Integer)obj, map.size()+1);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = sum(map.get(nums[i]) - 1);
            update(map.get(nums[i]));
        }
        return Arrays.asList(res);
    }

    public static int sum(int idx){
        int res = 0;
        while (idx > 0){
            res += bit[idx];
            idx -= idx & (-idx);
        }
        return res;
    }

    public static void update(int idx){
        while (idx > 0 && idx < bit.length){
            bit[idx]++;
            idx += idx & (-idx);
        }
    }

    public static void main(String[] args) {
        int[] input = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> res = countSmaller(input);
        for (int i: res){
            System.out.print(i + ", ");
        }
    }
}
