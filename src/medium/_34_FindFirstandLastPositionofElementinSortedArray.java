package medium;

public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null)
            return res;
        int lo = 0, hi = nums.length;
        while (lo < hi){
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target){
                hi = mid;
            }else if (nums[mid] < target){
                lo = mid + 1;
            }else {
                if (mid == 0 || nums[mid - 1] < target){
                    res[0] = mid;
                    break;
                }else {
                    hi = mid;
                }
            }
        }
        lo = 0;
        hi = nums.length;
        while (lo < hi){
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target){
                hi = mid;
            }else if (nums[mid] < target){
                lo = mid + 1;
            }else {
                if (mid == nums.length - 1 || nums[mid + 1] > target){
                    res[1] = mid;
                    break;
                }else {
                    lo = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _34_FindFirstandLastPositionofElementinSortedArray f = new _34_FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {5,7,7,8,8,10};
        int[] res = f.searchRange(nums, 6);
        for (int i: res) {
            System.out.printf("%d, ", i);
        }
    }
}
