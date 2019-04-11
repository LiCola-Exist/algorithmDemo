package string;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * 以Hash表实现的字典树，可以输入任意字符，
 * 但是性能相比限定字符集差，hash+equals比较+拆箱
 * 内存也高，包装类和HashMap的初始值，以Leetcode的提交结果支撑
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple"); trie.search("apple");   // returns true trie.search("app");     // returns
 * false trie.startsWith("app"); // returns true trie.insert("app"); trie.search("app");     //
 * returns true
 *
 * @author LiCola
 * @date 2019-04-11
 */
public class PrefixHashTrie {


  private static class TrieNode {

    private char c;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean hasWord;

    public TrieNode() {

    }

    public TrieNode(char c) {
      this.c = c;
    }
  }

  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public PrefixHashTrie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode cur = root;

    HashMap<Character, TrieNode> curChildren = cur.children;

    for (int i = 0, length = word.length(); i < length; i++) {
      char wordChar = word.charAt(i);
      if (curChildren.containsKey(wordChar)) {
        cur = curChildren.get(wordChar);
      } else {
        TrieNode childNode = new TrieNode(wordChar);
        curChildren.put(wordChar, childNode);
        cur = childNode;
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
    for (int i = 0, length = word.length(); i < length; i++) {
      char wordChar = word.charAt(i);
      if (cur.children.containsKey(wordChar)) {
        cur = cur.children.get(wordChar);
      } else {
        return null;
      }
    }
    return cur;
  }
}
