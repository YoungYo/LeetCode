package medium;

public class _63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m =obstacleGrid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 0) {
                res[0][i] = 1;
            }else
                break;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                res[i][0] = 1;
            }else
                break;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[n - 1][m - 1];
    }
    public static void main(String[] args) {
        _63_UniquePathsII up2 = new _63_UniquePathsII();
        int[][] obs1 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(up2.uniquePathsWithObstacles(obs1));
    }
}
