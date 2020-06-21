package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _54_SpiralMatrix {
    private boolean [][] record;
    private int r, c;
    private int[][] mat;
    List<Integer> res;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }
        r = matrix.length;
        c = matrix[0].length;
        mat = matrix;
        record = new boolean[r][c];
        res = new ArrayList<>(r * c);
        int row = 0;
        int startCol = 0;
        int col = 0;
        int startRow = 0;
        while (true){
            col = goRight(row, startCol);
            if (col < startCol){
                break;
            }
            startRow = row + 1;
            row = goDown(col, startRow);
            if (row < startRow) {
                break;
            }
            startCol = col - 1;
            col = goLeft(row, startCol);
            if (col > startCol){
                break;
            }
            startRow = row - 1;
            row = goUp(col, startRow);
            if (row > startRow) {
                break;
            }
            startCol = col + 1;
        }
        return res;
    }

    public int goRight(int row, int startCol) {
        int i = startCol;
        for (; i < c && !record[row][i]; i++) {
            res.add(mat[row][i]);
            record[row][i] = true;
        }
        return i - 1;
    }

    public int goDown(int col, int startRow) {
        int i = startRow;
        for (; i < r && !record[i][col]; i++) {
            res.add(mat[i][col]);
            record[i][col] = true;
        }
        return i - 1;
    }

    public int goLeft(int row, int startCol) {
        int i = startCol;
        for (; i >= 0 && !record[row][i]; i--){
            res.add(mat[row][i]);
            record[row][i] = true;
        }
        return i + 1;
    }

    public int goUp(int col, int startRow) {
        int i = startRow;
        for (; i >= 0 && !record[i][col]; i--){
            res.add(mat[i][col]);
            record[i][col] = true;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        _54_SpiralMatrix spiralMatrix = new _54_SpiralMatrix();
        int[][][] test = {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            }
        };
        for (int[][] matrix : test){
            List<Integer> res = spiralMatrix.spiralOrder(matrix);
            System.out.println(res);
        }
    }
}
