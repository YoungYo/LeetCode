public class _64_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int rows = grid.length;
        int[][] res = new int[rows][];
        res[0] = new int[grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            res[0][i] = grid[0][i] + res[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            res[i] = new int[grid[i].length];
            res[i][0] = grid[i][0] + res[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[rows - 1][res[rows - 1].length - 1];
    }

    public static int minPathSum1(int[][] grid) {
        if (grid == null)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] res = new int[rows][cols];
        res[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            res[0][i] = grid[0][i] + res[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            res[i][0] = grid[i][0] + res[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[rows - 1][cols - 1];
    }

    public static int minPathSum2(int[][] grid) {
        if (grid == null)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };

        int[][] grid1 = {
                {1}
        };

        int[][] grid2 = null;
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum1(grid));
        System.out.println(minPathSum2(grid));
    }
}
