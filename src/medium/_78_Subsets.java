package medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < res.size(); j++) {
                ArrayList<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                tmp.add(list);
            }
            res.addAll(tmp);
            tmp.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        _78_Subsets subsets = new _78_Subsets();
        int[] nums1 = {1,2,3};
        int[] nums = nums1;
        List<List<Integer>> res = subsets.subsets(nums);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.printf("%d, ", i);
            }
            System.out.println();
        }
    }
}
