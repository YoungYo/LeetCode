package medium;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                int k = n - 1 - i;
                int l = n - 1 - j;

                matrix[i][j] = matrix[l][i];
                matrix[l][i] = matrix[k][l];
                matrix[k][l] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _48_RotateImage ri = new _48_RotateImage();
        int[][] matrix1 = {
            {1,2,3},
		    {4,5,6},
		    {7,8,9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16}
        };

        int[][] matrix = matrix2;
        ri.rotate(matrix);

        for(int[] row: matrix){
            for(int i: row){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
