package medium;

public class _75_SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int less = 0, great = len - 1;
        for (int i = 0; i <= great;) {
            if (nums[i] < 1){
                swap(nums, i, less);
                less++;
                i++;
            }else if (nums[i] > 1){
                swap(nums, i, great);
                great--;
            }else {
                i++;
            }
        }
    }

    //交换arr[i]和arr[j]的值
    private void swap(int[] arr, int i, int j){
        if (i == j){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        _75_SortColors sc = new _75_SortColors();
        int[] input1 = {2,0,2,1,1,0};
        int[] input2 = {2,0,1};
        int[] input3 = {2};
        int[] nums = input1;
        sc.sortColors(nums);
        for(int i : nums){
            System.out.print(i + ",");
        }
    }
}
