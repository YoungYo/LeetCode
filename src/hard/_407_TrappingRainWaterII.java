package hard;

public class _407_TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length, res = 0;
        int[][] maxLeft = new int[m][n];
        for (int i = 0; i < m; i++) {
            maxLeft[i][0] = heightMap[i][0];
            for (int j = 1; j < n; j++) {
                maxLeft[i][j] = Math.max(maxLeft[i][j - 1], heightMap[i][j]);
            }
        }
        printMap(maxLeft);

        int[][] maxRight = new int[m][n];
        for (int i = 0; i < m; i++) {
            maxRight[i][n - 1] = heightMap[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                maxRight[i][j] = Math.max(maxRight[i][j + 1], heightMap[i][j]);
            }
        }
        printMap(maxRight);
        int[][] maxUp = new int[m][n];
        for (int i = 0; i < n; i++) {
            maxUp[0][i] = heightMap[0][i];
            for (int j = 1; j < m; j++) {
                maxUp[j][i] = Math.max(maxUp[j - 1][i], heightMap[j][i]);
            }
        }
        printMap(maxUp);

        int[][] maxDown = new int[m][n];
        for (int i = 0; i < n; i++) {
            maxDown[m - 1][i] = heightMap[m - 1][i];
            for (int j = m - 2; j >= 0; j--) {
                maxDown[j][i] = Math.max(maxDown[j + 1][i], heightMap[j][i]);
            }
        }
        printMap(maxDown);
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                res += Math.min(Math.min(maxRight[i][j], maxLeft[i][j]), Math.min(maxUp[i][j], maxDown[i][j])) - heightMap[i][j];
            }
        }
        return res;
    }

    public void printMap(int[][] max){
        for (int[] maxi: max) {
            for(int i: maxi){
                System.out.printf("%d,", i);
            }
            System.out.println();
        }
        System.out.println();
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
