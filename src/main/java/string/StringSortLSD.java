package string;

/**
 * Created by LiCola on 2018/3/24.
 */
public class StringSortLSD {

  private static final int ASCII_NUM_START = 48;
  private static final int ASCII_NUM_END = 57;

  private static final int R = 10;//简单化 纯数字的 字母表

  private static int charAt(String s, int index) {

    char charIndex = s.charAt(index);
    if (charIndex > ASCII_NUM_END || charIndex < ASCII_NUM_START) {
      throw new IllegalArgumentException("简单起见 只支持纯数字组成的字符串");
    }
    return charIndex - ASCII_NUM_START;
  }

  /**
   * 字符串排序 低位优先排序算法（LSD）
   */
  public static void sort(String[] a, int wordWidth) {
    int N = a.length;
    String[] aux = new String[N];//辅助空间
    for (int d = wordWidth - 1; d >= 0; d--) {

      int[] count = new int[R + 1];//使用R进制 生成一张表

      //统计频率
      for (int i = 0; i < N; i++) {
        count[charAt(a[i], d) + 1]++;
      }

      //将频率转换为索引
      for (int r = 0; r < R; r++) {
        count[r + 1] += count[r];
      }

      //将元素分类
      for (int i = 0; i < N; i++) {
        aux[count[charAt(a[i], d)]++] = a[i];
      }

      //回写
      for (int i = 0; i < N; i++) {
        a[i] = aux[i];
      }
    }
  }


}
