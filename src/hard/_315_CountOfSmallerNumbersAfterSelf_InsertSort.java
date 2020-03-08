package hard;

import java.util.LinkedList;
import java.util.List;

public class _315_CountOfSmallerNumbersAfterSelf_InsertSort {

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null)
            return null;
        int len = nums.length;
        List<Integer> res = new LinkedList<>();
        int[] sort = new int[len];
        for (int i = len - 1; i >= 0; i--){
            int j = len - 1 - i;
            int count = 0;
            while (j > 0 && nums[i] > sort[j - 1]){
                sort[j] = sort[j - 1];
                j--;
                count++;
            }
            sort[j] = nums[i];
            res.add(0, count);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] input = {5, 2, 6, 1, 0};
//        int[] input = {5};
//        int[] input = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        int[] input =   {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100};
//        int[] help = new int[input.length];
//        util.BinaryIndexedTree bit = new util.BinaryIndexedTree(input);
        List<Integer> res = countSmaller(input);
        for (int i: res){
            System.out.print(i + ", ");
        }

//        for(int i = 0; i < bit.BIT.length; i++){
//            System.out.println(bit.BIT[i]);
//        }
    }
}
