//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'.
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 5027 👎 116

  
package leetcode.editor.en;

import java.util.Arrays;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        char[][][] matrix = {
                {
                        {'0','0','0','1'},
                        {'1','1','0','1'},
                        {'1','1','1','1'},
                        {'0','1','1','1'},
                        {'0','1','1','1'}
                },
                {
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','1','0','1','1'},
                        {'1','1','1','1','1'}
                },
                {
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','1','1','1','0'}
                },
            {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
            },
            {
                {'0', '1'},
                {'1', '0'}
            },
            {
                {'0'}
            }
        };
        int result = solution.maximalSquare(matrix[2]);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
    class Solution {
        // 我自己的动态规划算法实现
        public int maximalSquare(char[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            // 连续1的个数，第一个元素代表横向的，第二个元素代表纵向的
            int[][][] continuousOneCount = new int[height][width][2];
            int[][] maxEdgeLength = new int[height][width];
            int result = 0;
            for (int i = 0; i < height; i++) {
                int horizontalContinuous = 1;
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == '0') {
                        horizontalContinuous = 0;
                    }
                    continuousOneCount[i][j][0] = horizontalContinuous++;
                }
            }
            for (int i = 0; i < width; i++) {
                int verticalContinuous = 1;
                for (int j = 0; j < height; j++) {
                    if (matrix[j][i] == '0') {
                        verticalContinuous = 0;
                    }
                    continuousOneCount[j][i][1] = verticalContinuous++;
                }
            }
            for (int i = 0; i < width; i++) {
                maxEdgeLength[0][i] = matrix[0][i] - '0';
                if (maxEdgeLength[0][i] == 1) {
                    result = 1;
                }
            }
            for (int i = 0; i < height; i++) {
                maxEdgeLength[i][0] = matrix[i][0] - '0';
                if (maxEdgeLength[i][0] == 1) {
                    result = 1;
                }
            }
            for (int i = 1; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    int edgeLength = maxEdgeLength[i - 1][j - 1];
                    int minContinuous = Math.min(continuousOneCount[i][j][0], continuousOneCount[i][j][1]);
                    if (edgeLength > 0) {
                        if (minContinuous > edgeLength) {
                            maxEdgeLength[i][j] = edgeLength + 1;
                        } else {
                            maxEdgeLength[i][j] = minContinuous;
                        }
                    } else {
                        maxEdgeLength[i][j] = minContinuous > 0 ? 1 : 0;
                    }
                    result = Math.max(maxEdgeLength[i][j], result);
                }
            }
            for (int i = 0; i < height; i++) {
                System.out.println(Arrays.toString(maxEdgeLength[i]));
            }
            return result * result;
        }
    }
*/
    class Solution {

        public int maximalSquare(char[][] matrix) {
//             return dpSolution(matrix);
            return dfsSolution(matrix);
        }

        // 别人的动态规划算法实现
        public int dpSolution(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dp = new int[n+1];
            int ans = 0;
            int pre = 0, tmp = 0;
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    tmp = dp[j];
                    if(matrix[i-1][j-1] == '1'){
                        dp[j] = Math.min(Math.min(dp[j], dp[j-1]), pre) + 1;
                        ans = Math.max(ans, dp[j]);
                    }else {
                        dp[j] = 0;
                    }
                    pre = tmp;
                }
                System.out.println(Arrays.toString(dp));
            }
            return ans*ans;
        }

        // 别人的深度优先搜索算法实现
        private int row;
        private int col;
        public int dfsSolution(char[][] matrix) {
            row = matrix.length;
            col = matrix[0].length;
            return dfs(1, matrix, 0);
        }

        private int dfs(int maxLen, char[][] matrix, int curI) {
            //遍历每点，dfs判断能否构成 maxLen 大小的正方形
            //由于是判断maxLen大小正方形，因此对循环上限做了限定
            //优化：不光记录I，还记录j
            for (int i = curI; i <= row - maxLen; i++) {
                for (int j = 0; j <= col - maxLen; j++) {
                    //若当前点为'1'，且能构成 maxLen 大小的正方形，升级，判断 maxLen+1
                    if (matrix[i][j] == '1' && judge(maxLen, matrix, i, j)) {
                        return Math.max(maxLen * maxLen, dfs(maxLen + 1, matrix, i));
                    }
                }
            }
            return 0;
        }

        private boolean judge(int maxLen, char[][] matrix, int i, int j) {
            //判断以当前点为 左上角，能否构成 maxLen 大小的正方形
            for (int x = i; x < i + maxLen; x++) {
                for (int y = j; y < j + maxLen; y++) {
                    if (matrix[x][y] == '0') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}