package hard;

import java.util.ArrayList;
import java.util.List;

public class _212_WordSearchII_Trie {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root =  new Trie();

        for(String w : words) {
            buildTrie(root, w);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, Trie p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.get(c) == null) return;
        p = p.get(c);
        if (p.getWord() != null) {   // found one
            res.add(p.getWord());
            p.setWord(null);     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private void buildTrie(Trie root, String w)
    {
        Trie current = root;
        for(char c : w.toCharArray()) {
            current = current.getAndAdd(c);
        }

        current.setWord(w);
    }
}

class Trie {
    private Trie[] links = new Trie[26];

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Trie getAndAdd(char ch) {
        int index = ch - 'a';

        Trie trie = links[index];

        if(trie == null) {
            trie = new Trie();
            links[index] = trie;
        }

        return trie;
    }

    public Trie get(char ch) {
        int index = ch - 'a';

        Trie trie = links[index];
        return trie;
    }
}
