import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _15_3Sum {
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        // value counter
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2;){
            if (nums[i] > 0) return res;
            int lo = i + 1;
            int hi = len - 1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < len - 1 && nums[lo] == nums[++lo]);
                    while (i < hi && nums[hi] == nums[--hi]);
                }else if (sum < 0){
                    while (lo < len - 1 && nums[lo] == nums[++lo]);
                }else if (sum > 0){
                    while (i < hi && nums[hi] == nums[--hi]);
                }
            }
            while (i < len - 2 && nums[i] == nums[++i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {1,-1,-1,0};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> i : res){
            for (Integer j: i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
    }
}
