import java.util.Arrays;

public class _41_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i = 0, len = nums.length;
        while (i < len && nums[i] <= 0) i++;
        if (i == len) return 1;
        int j = 1;
        for (; i < len; j++){
            if (nums[i] != j) return j;
            while (i < len -1 && nums[i] == nums[++i]);
        }
        return j;
    }

     public static int firstMissingPositive1(int[] nums) {
        for(int i=0; i<nums.length; i++){
           if(nums[i]>0 && nums[i] <= nums.length && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]) {
              swap(nums, i, nums[i]-1);
              i--;
           }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length +1;
    }

    private static void swap(int[]nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {4,3,1,2,0};
//        int[] nums = {1,2,1,2,0};
//        int[] nums = {1,2,7,0,0,1,5,0,3,0,3};
        System.out.println(firstMissingPositive1(nums));
    }
}
