package medium;

public class _79_WordSearch {
    char[][] board;
    String word;
    int wordLen;
    char beginChar, endChar;
    boolean[][] visited;
    int R, C;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        R = board.length;
        C = board[0].length;
        visited = new boolean[R][C];
        wordLen = word.length();
        beginChar = word.charAt(0);
        endChar = word.charAt(wordLen - 1);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == beginChar){
                    boolean res = dp(i, j, 0);
                    if (res){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //start_R和start_C是开始遍历的位置，idx是从word的第几个字符开始检查
    public boolean dp(int startR, int startC, int idx){
        if (idx == wordLen - 1 && board[startR][startC] == endChar){
            return true;
        }
        visited[startR][startC] = true;
        idx++;
        for (int k = 0; k < 4; k++) {
            int nr = startR + dr[k];
            int nc = startC + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && board[nr][nc] == word.charAt(idx)) {
                boolean res = dp(nr, nc, idx);
                if (res){
                    return true;
                }
            }
        }
        visited[startR][startC] = false;
        return false;
    }
    public static void main(String[] args) {
        _79_WordSearch ws = new _79_WordSearch();
        char[][] board1 = {
            {'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        char[][] board2= {
                {'a','a'},
        };
        String word4 = "aaa";
        char[][] testboard = board1;
        String testword = word3;

        System.out.println(ws.exist(testboard, testword));
    }
}
