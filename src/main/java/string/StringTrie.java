package string;

/**
 * Created by LiCola on 2018/4/10.
 */
public class StringTrie<V> {

  private static final int ASCII_ALPHABET_START = 97;
  private static final int ASCII_ALPHABET_END = 122;

  private static final int R = 26;//简单化 纯英文字母 字母表

  private Node root;

  private static class Node {

    private Object value;
    private Node[] next = new Node[R];
  }

  public void put(String key, V value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node x, String key, V value, int d) {
    if (x == null) {
      x = new Node();
    }

    if (d == key.length()) {
      x.value = value;
      return x;
    }

    int index = charAt(key, d);//找到第d个字符所对应的子单词查找树
    x.next[index] = put(x.next[index], key, value, d + 1);
    return x;
  }


  public V get(String key) {
    Node x = get(root, key, 0);
    if (x == null) {
      return null;
    } else {
      return (V) x.value;
    }
  }

  private Node get(Node x, String key, int d) {
    if (x == null) {
      return null;
    }

    if (d == key.length()) {
      return x;
    }
    int index = charAt(key, d);//找到第d个字符所对应的子单词查找树
    return get(x.next[index], key, d + 1);
  }

  private static int charAt(String s, int d) {
    char charIndex = s.charAt(d);
    assert charIndex >= ASCII_ALPHABET_START && charIndex <= ASCII_ALPHABET_END;
    return charIndex - ASCII_ALPHABET_START;
  }
}
