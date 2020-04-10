package hard;

import java.util.Arrays;

public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        if (R == 0){
            return 0;
        }
        int C = matrix[0].length, maxArea = 0;
        int[] left = new int[C], right = new int[C], height = new int[C];
        Arrays.fill(right, C);
        for (int i = 0; i < R; i++) {
            int lb = 0, rb = C;
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], lb);
                }else {
                    left[j] = 0;
                    lb = j + 1;
                }
            }

            for (int j = C - 1; j >= 0; j--) {
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], rb);
                }else {
                    right[j] = C;
                    rb = j;
                }
            }

            for (int j = 0; j < C; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        _85_MaximalRectangle mr = new _85_MaximalRectangle();
        char[][] matrix1 = {
            {'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
        };

        char[][] matrix = matrix1;
        System.out.println(mr.maximalRectangle(matrix));
    }
}
