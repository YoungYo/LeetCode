package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120_Triangle {
    public static int minimumTotal_iteration(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int rows = triangle.size();
        int[][] res = new int[rows][];
        res[0] = new int[1];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < rows; i++) {
            res[i] = new int[i + 1];
            res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                if (j == i)
                    res[i][j] = res[i - 1][j - 1] + cur;
                else
                    res[i][j] = Math.min(res[i - 1][j] + cur, res[i - 1][j - 1] + cur);
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < res[rows - 1].length; i++) {
            if (res[rows - 1][i] < minPath)
                minPath = res[rows - 1][i];
        }
        return minPath;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {//递归法
        if (triangle == null || triangle.isEmpty()) return 0;
        return minimumTotalHelper(triangle, 0, 0, new int[triangle.size()][triangle.size()]);
    }

    static int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];
        if (row == triangle.size() - 1) {
            return memo[row][col] = triangle.get(row).get(col);
        }

        int left = minimumTotalHelper(triangle, row + 1, col, memo);
        int right = minimumTotalHelper(triangle, row + 1, col + 1, memo);
        return memo[row][col] = Math.min(left, right) + triangle.get(row).get(col);
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(l1, l2, l3, l4));

        System.out.println(minimumTotal(triangle));
    }
}
