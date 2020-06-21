package medium;

import java.util.Arrays;

public class _73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean firstColZero = false;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0){
                firstColZero = true;
            }
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColZero){
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _73_SetMatrixZeroes setMatrixZeroes = new _73_SetMatrixZeroes();
        int[][][] matrices = {
                {
                        {1,1,1},
                        {1,0,1},
                        {1,1,1}
                },
                {
                        {1,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}
                }
        };

        for (int[][] matrix : matrices){
            setMatrixZeroes.setZeroes(matrix);
            for (int[] row : matrix){
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
        }
    }
}
