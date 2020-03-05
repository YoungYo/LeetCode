package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length == 1){
            res.add(new ArrayList<>());
            res.get(0).add(nums[0]);
        }
        boolean[] visited = new boolean[nums.length];
        return recursive(nums, visited);
    }

    public List<List<Integer>> recursive(int[] nums, boolean[] visited){
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]){
                boolean[] vi = Arrays.copyOf(visited, visited.length);
                vi[j] = true;
                List<List<Integer>> temp = recursive(nums, vi);
                for (List<Integer> list: temp){
                    list.add(nums[j]);
                    res.add(list);
                }
            }
        }
        if (res.size() == 0){
            res.add(new ArrayList<>());
        }
        return res;
    }

    public static void main(String[] args) {
        _46_Permutations permutations = new _46_Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> res = permutations.permute(nums);

        for(List<Integer> list: res){
            for(Integer i: list){
                System.out.printf("%d, ", i);
            }
            System.out.println();
        }
    }
}
