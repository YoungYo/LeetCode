package medium;

import java.util.Objects;

public class _208_ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("a"));
        trie.insert("hello");
        trie.insert("hi");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hel"));
        System.out.println(trie.startsWith("el"));
        int a = 0;
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            trieNode.insert(c);
            trieNode = trieNode.getChild(c - 'a');
        }
        trieNode.setEndOfWord(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, true);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix, false);
    }


    public boolean search(String word, boolean emptyWord) {
        TrieNode trieNode = root;
        TrieNode t;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            t = trieNode.getChild(idx);
            if (Objects.isNull(t)) {
                return false;
            }
            trieNode = trieNode.getChild(idx);
        }
        if (emptyWord) {
            return trieNode.isEndOfWord();
        } else {
            return true;
        }
    }
}

class TrieNode {
    private TrieNode[] child;
    private boolean endOfWord;

    public TrieNode() {

    }

    public TrieNode(char c) {
    }

    public void insert(char c) {
        if (Objects.isNull(child)) {
            child = new TrieNode[26];
        }
        int idx = c - 'a';
        if (Objects.isNull(child[idx])) {
            child[idx] = new TrieNode(c);
        }
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public TrieNode getChild(int idx) {
        return Objects.isNull(this.child) ? null : this.child[idx];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
