package string;

/**
 * Created by LiCola on 2018/4/9.
 */
public class StringSortMSD {

  private static final int ASCII_ALPHABET_START = 97;
  private static final int ASCII_ALPHABET_END = 122;

  private static final int R = 26;//简单化 纯英文字母 字母表
  private static final int CUTOFF = 0;   // cutoff to insertion sort

  public static void sort(String[] a) {
    int n = a.length;
    String[] aux = new String[n];
    sort(a, 0, n - 1, 0, aux);
  }


  // sort from a[lo] to a[hi], starting at the dth character
  private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

    // cutoff to insertion sort for small subarrays
    if (hi <= lo + CUTOFF) {
      insertion(a, lo, hi, d);
      return;
    }

    // compute frequency counts
    int[] count = new int[R + 2];
    for (int i = lo; i <= hi; i++) {
      count[charAt(a[i], d) + 2]++;
    }

    // transform counts to indicies
    for (int r = 0; r < R + 1; r++) {
      count[r + 1] += count[r];
    }

    // distribute
    for (int i = lo; i <= hi; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }

    // copy back
    for (int i = lo; i <= hi; i++) {
      a[i] = aux[i - lo];
    }

    // recursively sort for each character (excludes sentinel -1)
    for (int r = 0; r < R; r++) {
      sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
    }
  }

  // return dth character of s, -1 if d = length of string
  private static int charAt(String s, int d) {
    assert d >= 0 && d <= s.length();
    if (d == s.length()) {
      return -1;
    }
    char charIndex = s.charAt(d);
    assert charIndex >= ASCII_ALPHABET_START && charIndex <= ASCII_ALPHABET_END;
    return charIndex - ASCII_ALPHABET_START;
  }

  // insertion sort a[lo..hi], starting at dth character
  private static void insertion(String[] a, int lo, int hi, int d) {
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  // exchange a[i] and a[j]
  private static void exch(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  // is v less than w, starting at character d
  private static boolean less(String v, String w, int d) {
    // assert v.substring(0, d).equals(w.substring(0, d));
    for (int i = d; i < Math.min(v.length(), w.length()); i++) {
      if (v.charAt(i) < w.charAt(i)) {
        return true;
      }
      if (v.charAt(i) > w.charAt(i)) {
        return false;
      }
    }
    return v.length() < w.length();
  }
}
