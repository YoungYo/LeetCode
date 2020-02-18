import java.util.Arrays;
import java.util.List;

public class _315_CountOfSmallerNumbersAfterSelf_Solution {

    public List<Integer> countSmaller(int[] nums) {
        int l = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<l; i++){
            if (nums[i] > max){
                max = nums[i];
            }
            if (nums[i] < min){
                min = nums[i];
            }
        }
        int bush_size = max-min+1;
        int[] tree = new int[bush_size];
        Integer[] raw_result = new Integer[l];
        for (int i=l-1; i>=0; i--){
            int cur = nums[i] - min + 1;
            raw_result[i] = find(tree, cur-1);
            update(tree, cur);
        }
        return Arrays.asList(raw_result);
    }

    public void update(int[] arr, int key){
        while(key < arr.length){
            arr[key] ++;
            key += key & (-key);
        }
    }

    public int find(int[] arr, int key){
        int sum = 0;
        while(key > 0){
            sum += arr[key];
            key -= key & (-key);
        }
        return sum;
    }

    public static void main(String[] args) {
        _315_CountOfSmallerNumbersAfterSelf_Solution solution = new _315_CountOfSmallerNumbersAfterSelf_Solution();
        int[] input = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> res = solution.countSmaller(input);
        for (int i: res){
            System.out.print(i + ", ");
        }
    }
}
