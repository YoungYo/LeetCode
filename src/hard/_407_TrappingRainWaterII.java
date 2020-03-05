package hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class _407_TrappingRainWaterII {
    //地图上的柱子
    private static class Bar implements Comparable<Bar>{
        int i; //柱子所在的行
        int j; //柱子所在的列
        int height; //柱子的高度
        Bar(int i, int j, int height){
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Bar o) {
            return this.height - o.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3){
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Bar> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            Bar bar1 = new Bar(i, 0, heightMap[i][0]);
            pq.add(bar1);
            visited[i][0] = true;
            Bar bar2 = new Bar(i, n - 1, heightMap[i][n - 1]);
            pq.add(bar2);
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            Bar bar1 = new Bar(0, i, heightMap[0][i]);
            pq.add(bar1);
            visited[0][i] = true;
            Bar bar2 = new Bar(m - 1, i, heightMap[m - 1][i]);
            pq.add(bar2);
            visited[m - 1][i] = true;
        }
        int res = 0;
        int maxBound = Integer.MIN_VALUE; //相当于二维空间里面的maxLeft，即能够拦截住的最大水位
        while (!pq.isEmpty()){
            Bar bar = pq.poll();
            maxBound = Math.max(maxBound, bar.height);
            Bar temp;
            if (bar.i - 1 >= 0 && !visited[bar.i - 1][bar.j]){
                temp = new Bar(bar.i - 1, bar.j, heightMap[bar.i - 1][bar.j]);
                pq.add(temp);
                visited[bar.i - 1][bar.j] = true;
                if (maxBound > temp.height){
                    res += maxBound - temp.height;
                }
            }
            if (bar.i + 1 < m && !visited[bar.i + 1][bar.j]){
                temp = new Bar(bar.i + 1, bar.j, heightMap[bar.i + 1][bar.j]);
                pq.add(temp);
                visited[bar.i + 1][bar.j] = true;
                if (maxBound > temp.height){
                    res += maxBound - temp.height;
                }
            }
            if (bar.j - 1 >= 0 && !visited[bar.i][bar.j - 1]){
                temp = new Bar(bar.i, bar.j - 1, heightMap[bar.i][bar.j - 1]);
                pq.add(temp);
                visited[bar.i][bar.j - 1] = true;
                if (maxBound > temp.height){
                    res += maxBound - temp.height;
                }
            }
            if (bar.j + 1 < n && !visited[bar.i][bar.j + 1]){
                temp = new Bar(bar.i, bar.j + 1, heightMap[bar.i][bar.j + 1]);
                pq.add(temp);
                visited[bar.i][bar.j + 1] = true;
                if (maxBound > temp.height){
                    res += maxBound - temp.height;
                }
            }
        }
        return res;
    }

    private static class Cell implements Comparable<Cell> {
        private int row;
        private int col;
        private int height;
        public Cell(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.height = v;
        }
        @Override
        public int compareTo(Cell other) {
            return height - other.height;
        }
    }
    private int water;
    private boolean[][] visited;
    public int trapRainWater1(int[][] heightMap) {
        if (heightMap.length == 0) return 0;
        PriorityQueue<Cell> walls = new PriorityQueue<>();
        water = 0;
        visited = new boolean[heightMap.length][heightMap[0].length];
        int rows = heightMap.length, cols = heightMap[0].length;

        //build wall;
        //all cells on parameter cannot store water as they will leak, so use
        //them as init for wall
        for (int c = 0; c < cols; c++) {
            //top row
            walls.add(new Cell(0, c, heightMap[0][c]));
            visited[0][c] = true;
            //bottom row
            walls.add(new Cell(rows - 1, c, heightMap[rows - 1][c]));
            visited[rows - 1][c] = true;
        }
        for (int r = 1; r < rows - 1; r++) {
            //left col
            walls.add(new Cell(r, 0, heightMap[r][0]));
            visited[r][0] = true;
            //right col
            walls.add(new Cell(r, cols - 1, heightMap[r][cols - 1]));
            visited[r][cols - 1] = true;
        }
        //end build wall;

        while(walls.size() > 0) {
            Cell min = walls.poll();
            visit(heightMap, min, walls);
        }
        return water;
    }

    //algorithm is basically to flood fill/BFS from wall, extending wall until
    //all cells visited in matrix
    private void visit(int[][] height, Cell start, PriorityQueue<Cell> walls) {
        fill(height, start.row + 1, start.col, walls, start.height);
        fill(height, start.row - 1, start.col, walls, start.height);
        fill(height, start.row, start.col + 1, walls, start.height);
        fill(height, start.row, start.col - 1, walls, start.height);
    }

    //[row][col] is neighbor of wall, min is minimum of wall, i.e. next cell to look in wall
    //need priority queue to manage traversal of wall, until no more wall left
    private void fill(int[][] height, int row, int col, PriorityQueue<Cell> walls, int min) {
        if (row < 0 || col < 0 || row >= height.length || col >= height[0].length || visited[row][col]) return;

        visited[row][col] = true;
        if (height[row][col] >= min) { //taller than min of wall, clearly cannot store water
            //must be added to wall itself
            walls.add(new Cell(row, col, height[row][col]));

            return;
        } else {
            //less than wall, so can add water
            System.out.println(row + ", " + col + " height = " + height[row][col] + ", bar = " + min);
            water += min - height[row][col];

            fill(height, row + 1, col, walls, min);
            fill(height, row - 1, col, walls, min);
            fill(height, row, col + 1, walls, min);
            fill(height, row, col - 1, walls, min);
        }
    }
    public static void main(String[] args) {
        _407_TrappingRainWaterII tr2 = new _407_TrappingRainWaterII();
        int[][] heightMap1 = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
			};
        int[][] heightMap2 = {
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        System.out.println(tr2.trapRainWater(heightMap2));
    }
}
