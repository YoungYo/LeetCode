package medium;

public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public int search_binary(int nums[], int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo < hi){
            int mid = ( lo + hi ) / 2;
            if( nums[mid] > nums[hi] )
                lo = mid + 1;
            else
                hi = mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = n - 1;
        // The usual binary search and accounting for rotation.
        while(lo <= hi){
            int mid = ( lo + hi ) / 2;
            int realmid = ( mid + rot ) % n;
            if ( nums[realmid] == target )
                return realmid;
            if ( nums[realmid] < target )
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _33_SearchinRotatedSortedArray srsa = new _33_SearchinRotatedSortedArray();
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {7,8,1,2,3,4,5,6};
        int[] nums = nums2;
        int target = 2;
        System.out.println(srsa.search(nums, target));
    }
}
