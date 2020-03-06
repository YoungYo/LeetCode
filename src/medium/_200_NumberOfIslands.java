package medium;

import java.util.Stack;

public class _200_NumberOfIslands {
    /** 递归版深度优先搜索（DFS） */
    public static int numIslands_recursive(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j){
        if (grid[i][j] == '2' || grid[i][j] == '0') //该位置的元素为‘2’说明该位置已经遍历过了，‘0’说明是水，不用遍历
            return;
        grid[i][j] = '2';
        int rows = grid.length, columns = grid[i].length;
        if (i + 1 < rows) dfs(grid, i + 1, j);
        if (i - 1 >= 0) dfs(grid, i - 1, j);
        if (j + 1 < columns) dfs(grid, i, j + 1);
        if (j - 1 >= 0) dfs(grid, i, j - 1);
    }

    public static int numIslands_iteration(char[][] grid){
        int count = 0, rows = grid.length, columns, row, col;
        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    columns = grid[i].length;
                    stack.push(new Integer[]{i, j});
                    while (!stack.isEmpty()){
                        Integer[] index = stack.pop();
                        row = index[0];
                        col = index[1];
                        grid[row][col] = '2';
                        if (row + 1 < rows    && grid[row + 1][col] == '1') stack.push(new Integer[]{row + 1, col});
                        if (row - 1 >= 0      && grid[row - 1][col] == '1') stack.push(new Integer[]{row - 1, col});
                        if (col + 1 < columns && grid[row][col + 1] == '1') stack.push(new Integer[]{row, col + 1});
                        if (col - 1 >= 0      && grid[row][col - 1] == '1') stack.push(new Integer[]{row, col - 1});
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'1','0','0','1','1'}
        };

        char[][] grid3 = {
                {'1'}
        };

        char[][] grid4 = {
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid5 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
        };

        char[][] grid6 = {
                {'0','1','0','1','0'},
                {'0','1','0','1','0'},
                {'0','1','1','1','0'},
                {'0','0','0','0','0'}
        };

        char[][] input = grid1;
        char[][] copy = new char[input.length][];
        for (int i = 0; i < input.length; i++) {
            copy[i] = input[i].clone();
        }
        System.out.println(numIslands_recursive(input));
        System.out.println(numIslands_iteration(copy));
    }
}
