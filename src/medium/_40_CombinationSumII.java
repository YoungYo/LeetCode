package medium;

import util.MyStack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        int[] temp = new int[candidates.length];
        MyStack<Integer> stack = new MyStack<>(candidates.length);
        int i = 0;
        int sum = 0;
        out: do {
            if (i < candidates.length){
                temp[stack.size()] = candidates[i];
                stack.push(i);
                sum += candidates[i];
                if (sum >= target){
                    if (sum == target){
                        List<Integer> subres = new ArrayList<>(stack.size());
                        for (int j = 0; j < stack.size(); j++) {
                            subres.add(temp[j]);
                        }
                        res.add(subres);
                    }
                    do {
                        i = stack.pop();
                        sum -= candidates[i];
                    } while (i == candidates.length - 1 && !stack.isEmpty());

                    int a = candidates[i++];
                    while (i < candidates.length && candidates[i] == a) i++;
                }else {
                    i++;
                }
            }else {
                do {
                    i = stack.pop();
                    sum -= candidates[i];
                } while (i == candidates.length - 1 && !stack.isEmpty());

                int a = candidates[i++];
                while (i < candidates.length && candidates[i] == a) i++;
            }
        }while (!stack.isEmpty() || i < candidates.length);
        return res;
    }

    public List<List<Integer>> combinationSum2_recursive(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]){
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            backtrace(res, path, candidates, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        _40_CombinationSumII cs2 = new _40_CombinationSumII();
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;

        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;

        int[] candidates3 = {1};
        int target3 = 2;

        int[] candidates4 = {1,1};
        int target4 = 1;

        int[] candidates5 = {3,1,3,5,1,1};
        int target5 = 8;

        int[] candidates = candidates1;
        int target = target1;
        List<List<Integer>> res1 = cs2.combinationSum2(candidates, target);
        for (int i = 0; i < res1.size(); i++) {
            for (int j = 0; j < res1.get(i).size(); j++) {
                System.out.printf("%d, ", res1.get(i).get(j));
            }
            System.out.println();
        }

        System.out.println();
        List<List<Integer>> res2 = cs2.combinationSum2_recursive(candidates, target);
        for (int i = 0; i < res2.size(); i++) {
            for (int j = 0; j < res2.get(i).size(); j++) {
                System.out.printf("%d, ", res2.get(i).get(j));
            }
            System.out.println();
        }
    }
}
