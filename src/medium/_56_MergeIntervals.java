package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        int[][] res = new int[intervals.length][];
        res[0] = new int[2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (res[j][0] <= intervals[i][0] && intervals[i][0] <= res[j][1]){
                res[j][1] = Math.max(res[j][1], intervals[i][1]);
            }else {
                res[++j] = new int[2];
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
        }
        int[][] res1 = new int[j + 1][];
        for (int i = 0; i <= j; i++) {
            res1[i] = res[i];
        }
        return res1;
    }

    public int[][] merge1(int[][] intervals) {
        int max=0;
        for(int[] arr: intervals){
            max= Math.max(max, arr[1]);
        }
        boolean[] check= new boolean[( max + 1 ) * 2];
        for(int[] arr: intervals){
            for(int i = arr[0] * 2; i <= arr[1] * 2; i++){
                if(!check[i]){
                    check[i] = true;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i <= 2 * max; i++){
            if(check[i]){
                int start = i / 2;
                while(check[i]){
                    i++;
                }
                list.add(new int[]{start, (i - 1) / 2});
            }
        }
        int[][] result= new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input1 = {{1,3},{8,10},{15,18},{2,6}};
        int[][] input2 = {{1,4},{4,5}};
        int[][] input3 = {{1,4},{5,6}};

        int[][] input = input3;
        _56_MergeIntervals mi = new _56_MergeIntervals();
        int[][] res = mi.merge(input);
        for (int[] re : res) {
            System.out.print(Arrays.toString(re) + ", ");
        }
        System.out.println();
        res = mi.merge1(input);
        for (int[] re : res) {
            System.out.print(Arrays.toString(re) + ", ");
        }
    }
}
