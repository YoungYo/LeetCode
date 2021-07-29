//Write an efficient algorithm that searches for a target value in an m x n inte
//ger matrix. The matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search Divide and Conquer Matrix 
// 👍 5264 👎 97

  
package leetcode.editor.en;
public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        int[][][] inputs = {
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },
                {
                        {1, 4},
                        {2, 5}
                }
        };
        int[] targets = {5, 20};
        System.out.println(solution.searchMatrix(inputs[0], targets[1]));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int start = 0, end = m, horizontal, vertical;
            while (start < end) {
                int mid = (start + end) / 2;
                int t = matrix[mid][0];
                if (t == target) {
                    return true;
                } else if (t < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            vertical = start;
            start = 0;
            end = n;
            while (start < end) {
                int mid = (start + end) / 2;
                int t = matrix[0][mid];
                if (t == target) {
                    return true;
                } else if (t < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            horizontal = start;
            while (vertical > 0 || horizontal > 0) {
                if (matrix[vertical - 1][horizontal - 1] < target) {
                    return false;
                }
                start = 0;
                end = horizontal;
                while (start < end) {
                    int mid = (start + end) / 2;
                    int t = matrix[vertical - 1][mid];
                    if (t == target) {
                        return true;
                    } else if (t < target) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                start = 0;
                end = vertical;
                while (start < end) {
                    int mid = (start + end) / 2;
                    int t = matrix[mid][horizontal - 1];
                    if (t == target) {
                        return true;
                    } else if (t < target) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                horizontal--;
                vertical--;
            }
            return false;
        }
    }
*/
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //must select a corner that its left is great than it and right less than it or vice verse, since need to decide which direction to go
            int m = matrix.length;
            int n = matrix[0].length;
            int r = m - 1;
            int c = 0;
            while(r >=0 && c<=n-1) {
                if(matrix[r][c] == target) {
                    return true;
                } else if(matrix[r][c] > target) {
                    r--;
                } else {
                    c++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}