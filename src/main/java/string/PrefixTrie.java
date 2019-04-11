package string;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * 限定字符集a-z的字典树
 * Trie trie = new Trie();
 *
 * trie.insert("apple"); trie.search("apple");   // returns true trie.search("app");     // returns
 * false trie.startsWith("app"); // returns true trie.insert("app"); trie.search("app");     //
 * returns true
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * @author LiCola
 * @date 2019-04-11
 */
public class PrefixTrie {

  private static final int ASCII_ALPHABET_START = 97;
  private static final int ASCII_ALPHABET_END = 122;

  private static final int R = 26;//简单化 纯英文字母 字母表

  private static class TrieNode {

    private TrieNode[] children = new TrieNode[R];
    private boolean hasWord;

    public TrieNode() {

    }

  }

  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public PrefixTrie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode cur = root;

    TrieNode[] curChildren = cur.children;

    for (int i = 0, length = word.length(); i < length; i++) {
      char wordChar = word.charAt(i);
      int index = charAt(wordChar);
      cur = curChildren[index];
      if (cur == null) {
        cur = new TrieNode();
        curChildren[index] = cur;
      }
      curChildren = cur.children;

      //遍历到末尾 表示单词设置标志位
      if (i == length - 1) {
        cur.hasWord = true;
      }
    }
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode searchNode = searchNode(word);
    return searchNode != null && searchNode.hasWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {

    return searchNode(prefix) != null;

  }

  private TrieNode searchNode(String word) {

    TrieNode cur = root;

    TrieNode[] curChildren = cur.children;

    for (int i = 0, length = word.length(); i < length; i++) {
      char wordChar = word.charAt(i);
      int index = charAt(wordChar);
      cur = curChildren[index];
      if (cur == null) {
        return null;
      }
      curChildren = cur.children;
    }
    return cur;
  }

  private static int charAt(char charIndex) {
    assert charIndex >= ASCII_ALPHABET_START && charIndex <= ASCII_ALPHABET_END;
    return charIndex - ASCII_ALPHABET_START;
  }
}
