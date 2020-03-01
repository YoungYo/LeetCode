package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int begin){
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] <= target){
                List<Integer> list = new ArrayList<>(tempList);
                list.add(candidates[i]);
                if (target == candidates[i]){
                    res.add(list);
                    return;
                }
                backtrace(res, list, candidates, target - candidates[i], i);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum cs = new _39_CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = cs.combinationSum(candidates, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.printf("%d, ", res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
