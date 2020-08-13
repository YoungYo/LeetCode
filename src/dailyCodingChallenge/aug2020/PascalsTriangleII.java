package dailyCodingChallenge.aug2020;

import java.util.*;

/**
 * @author 王浩
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] arr = {1};
        int[] res = null;
        if (rowIndex <= 0) {
            return Collections.singletonList(1);
        }
        for (int i = 1; i <= rowIndex; i++) {
            res = new int[i + 1];
            res[0] = 1;
            res[i] = 1;
            for (int j = 1; j <= i / 2; j++) {
                int tmp = arr[j - 1] + arr[j];
                res[j] = tmp;
                res[i - j] = tmp;
            }
            arr = res;
        }
        ArrayList<Integer> integers = new ArrayList<>(res.length);
        for (int i : res) {
            integers.add(i);
        }
        return integers;
    }

    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        System.out.println(pascalsTriangleII.getRow(33));
    }
}
