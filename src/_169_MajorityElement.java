import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            Integer count = map.get(i);
            if (count == null){
                map.put(i, 1);
            }else {
                map.put(i, count+1);
            }
        }
        Integer max_count = Integer.MIN_VALUE, max_key = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max_count){
                max_count = entry.getValue();
                max_key = entry.getKey();
            }
        }
        return max_key == null ? -1 : max_key;
    }

    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i: nums){
            Integer count = map.getOrDefault(i, 0);
            map.put(i, count+1);
            if( (len & 1) == 0 && count+1 >= len/2)
                return i;
            if( (len & 1) == 1 && count+1 > len/2)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));
    }
}
