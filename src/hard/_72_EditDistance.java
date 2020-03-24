package hard;

public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0){
            return word2.length();
        }else if (word2.length() == 0){
            return word1.length();
        }
        int n = word1.length(), m = word2.length();
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (word1.charAt(0) == word2.charAt(j)) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (word1.charAt(i) == word2.charAt(0)) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (word1.charAt(i) == word2.charAt(j)) minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                else minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

    public static void main(String[] args) {
        _72_EditDistance ed = new _72_EditDistance();
//        String word1 = "horse", word2 = "ros";
        String word1 = "intention", word2 = "execution";
        System.out.println(ed.minDistance(word1, word2));
    }
}
