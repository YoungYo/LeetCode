import java.util.*;

public class _315_CountOfSmallerNumbersAfterSelf_MergeSort {

    private static List<Integer> res;
    private static Elem[] elems;

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null)
            return null;
        int len = nums.length;
        res = new ArrayList<>(len);
        for (int i = 0; i < len; i++){
            res.add(0);
        }
        if (nums.length == 1)
            return res;
        elems = new Elem[nums.length];
        for(int i = 0; i < nums.length; i++){
            Elem elem = new Elem(nums[i], i);
            elems[i] = elem;
        }
//        Elem[] sorted = mergeSort(elems, 0, len);
        mergeSort_recursion(elems, 0, len);
//        for (Elem i: sorted){
//            System.out.print(i.val + ", ");
//        }
//        System.out.println();
        return res;
    }

    private static Elem[] mergeSort(Elem[] elems, int low, int high){
        if (high > elems.length || low < 0)
            return null;
        int step = 1;
        while (step < high) {
            for (int i = low; i < high; i += step << 1) {
                int lo = i, hi = (i + (step << 1)) <= high ? (i + (step << 1)) : high; //定义二路归并的上界与下界
                int mid = i + step <= high ? (i + step) : high;
                merge(elems, lo, mid, hi);
            }

            //将i和i+step这两个有序序列进行合并
            //序列长度为step
            //当i以后的长度小于或者等于step时，退出
            step <<= 1;//在按某一步长归并序列之后，步长加倍
        }
        return elems;
    }

    private static void mergeSort_recursion(Elem[] elems, int low, int high){
        if (high > elems.length || low < 0 || low > high)
            return;
        int mid = (high - low) >> 1;
        if (mid == 0){
            return;
        }
        mid+=low;
        mergeSort_recursion(elems, low, mid);
        mergeSort_recursion(elems, mid, high);
        merge(elems, low, mid, high);
    }

    public static void merge(Elem[] elems, int lo, int mid, int hi){
        Elem[] right = Arrays.copyOfRange(elems, mid, hi); //数组后半段
        for (int i = mid - 1, j = right.length - 1, k = hi - 1; (i >= lo) || (j >= 0);) {
            if (i >= lo && j >= 0)
                if (elems[i].val > right[j].val){
                    int idx = elems[i].index;
                    res.set(idx, res.get(idx) + j + 1);
                    elems[k--] = elems[i--];
                }else {
                    elems[k--] = right[j--];
                }
            if (i >= lo && j < 0)
                elems[k--] = elems[i--];
            if (i < lo && j >= 0)
                elems[k--] = right[j--];
        }
    }

    public static void main(String[] args) {
//        int[] input = {5, 2, 6, 1, 3};
//        int[] input = {5};
        int[] input = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
//        int[] input =   {26,78,27,100,33,78};
//        int[] help = new int[input.length];
//        BinaryIndexedTree bit = new BinaryIndexedTree(input);
//        int[] sorted = mergeSort(input, 0, input.length);
//        for(int i: sorted){
//            System.out.print(i + ", ");
//        }
        List<Integer> res1 = _315_CountOfSmallerNumbersAfterSelf_InsertSort.countSmaller(input);
        res = countSmaller(input);
        for (int i: res){
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i: res1){
            System.out.print(i + ", ");
        }
    }
}

class Elem{
    public int val;
    public int index;

    public Elem(int val, int index){
        this.val = val;
        this.index = index;
    }
}