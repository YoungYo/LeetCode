package hard;

import java.util.Arrays;
import java.util.List;

public class _315_CountOfSmallerNumbersAfterSelf_Brute {

    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        Integer[] res = new Integer[len];
        for(int i = 0; i< len; i++){
            res[i] = 0;
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (nums[i] > nums[j]){
                    res[i]++;
                }
            }
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        int[] input = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> res = countSmaller(input);
        for (int i: res){
            System.out.print(i + ", ");
        }
    }
}
