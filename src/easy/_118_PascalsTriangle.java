package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        if (numRows == 1) {
            return res;
        }
        res.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return res;
        }
        for (int i = 1; i < numRows - 1; i++) {
            List<Integer> preLevel = res.get(i);
            int len = preLevel.size();
            Integer[] currLevel = new Integer[len + 1];
            currLevel[0] = 1;
            currLevel[len] = 1;
            for (int j = 0; j < preLevel.size() - 1; j++) {
                currLevel[j + 1] = preLevel.get(j) + preLevel.get(j + 1);
            }
            res.add(Arrays.asList(currLevel));
        }
        return res;
    }

    public static void main(String[] args) {
        _118_PascalsTriangle pascalsTriangle = new _118_PascalsTriangle();
        int[] test = {5};
        for (int numRows : test) {
            List<List<Integer>> res = pascalsTriangle.generate(numRows);
            res.forEach(System.out::println);
            System.out.println();
        }
    }
}
