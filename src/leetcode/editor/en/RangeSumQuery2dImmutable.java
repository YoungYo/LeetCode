//Given a 2D matrix matrix, handle multiple queries of the following type: 
//
// 
// Calculate the sum of the elements of matrix inside the rectangle defined by i
//ts upper left corner (row1, col1) and lower right corner (row2, col2). 
// 
//
// Implement the NumMatrix class: 
//
// 
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix matr
//ix. 
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
//elements of matrix inside the rectangle defined by its upper left corner (row1, 
//col1) and lower right corner (row2, col2). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 
//3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
//Output
//[null, 8, 11, 12]
//
//Explanation
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 
//0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -105 <= matrix[i][j] <= 105 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// At most 104 calls will be made to sumRegion. 
// 
// Related Topics Array Design Matrix Prefix Sum 
// 👍 1971 👎 227

  
package leetcode.editor.en;

public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][][] matrix = {
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                }
        };
        NumMatrix numMatrix = new RangeSumQuery2dImmutable().new NumMatrix(matrix[0]);
        System.out.println(numMatrix.sumRegion(0, 0, 4,1));
        System.out.println(numMatrix.sumRegion(0, 1, 4,1));
        System.out.println(numMatrix.sumRegion(3, 0, 4,3));
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int height = matrix.length, width = matrix[0].length;
            preSum = new int[height][width];
            for (int i = 0; i < height; i++) {
                int rowSum = 0;
                for (int j = 0; j < width; j++) {
                    rowSum += matrix[i][j];
                    preSum[i][j] = rowSum;
                }
            }
            for (int i = 0; i < width; i++) {
                for (int j = 1; j < height; j++) {
                    preSum[j][i] += preSum[j - 1][i];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return preSum[row2][col2];
            } else if (row1 == 0) {
                return preSum[row2][col2] - preSum[row2][col1 - 1];
            } else if (col1 == 0) {
                return preSum[row2][col2] - preSum[row1 - 1][col2];
            } else {
                return preSum[row2][col2] - preSum[row1 - 1][col2] - preSum[row2][col1 - 1] + preSum[row1 - 1][col1 - 1];
            }
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}