package hard;

import java.util.ArrayList;
import java.util.List;

public class _212_WordSearchII {
    char[][] board;
    String word;
    int wordLen;
    char beginChar, endChar;
    boolean[][] visited;
    int R, C;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    ArrayList<int[]>[] startMap = new ArrayList[26];
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        R = board.length;
        C = board[0].length;
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = board[i][j];
                int pos = c - 'a';
                if (startMap[pos] == null){
                    startMap[pos] = new ArrayList<>(R * C);
                }
                startMap[pos].add(new int[]{i, j});
            }
        }
        int wordsLen = words.length;
        ArrayList<String> res = new ArrayList<>(wordsLen);
        for(String str : words){
            if (exist(str)){
                res.add(str);
            }
        }
        return res;
    }
    public boolean exist(String word) {
        this.word = word;
        wordLen = word.length();
        beginChar = word.charAt(0);
        endChar = word.charAt(wordLen - 1);
        ArrayList<int[]> startIdx = startMap[beginChar - 'a'];
        if (startIdx != null) {
            for (int[] idx : startIdx) {
                boolean res = dp(idx[0], idx[1], 0);
                if (res) {
                    return true;
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
                    visited[startR][startC] = false;
                    return true;
                }
            }
        }
        visited[startR][startC] = false;
        return false;
    }

    public static void main(String[] args) {
        _212_WordSearchII ws2 = new _212_WordSearchII();
        char[][] board1 = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words1 = {"oath","pea","eat","rain"};

        char[][] board = board1;
        String[] words = words1;

        System.out.println(ws2.findWords(board, words));
    }
}
