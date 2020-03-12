package medium;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < 0 || k > 9 || n > 45){
            return res;
        }
        backtrace(res, new ArrayList<>(), 0, k, 1, n);
        return res;
    }

    //curLevel表示当前递归的层数，maxLevel表示递归的最大层数，curLevel必须小于等于maxLevel
    public void backtrace(List<List<Integer>> res, List<Integer> path, int curLevel, int maxLevel, int start, int target){
        if (target == 0 && curLevel == maxLevel){
            res.add(new ArrayList<>(path));
            return;
        }else if (target == 0 || curLevel == maxLevel){
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target < i){
                break;
            }
            path.add(i);
            backtrace(res, path, curLevel + 1, maxLevel, i + 1, target - i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _216_CombinationSumIII cs3 = new _216_CombinationSumIII();
        List<List<Integer>> res1 = cs3.combinationSum3(3, 9);
        for (List<Integer> i: res1) {
            for (Integer j: i) {
                System.out.printf("%d, ", j);
            }
            System.out.println();
        }
    }
}
