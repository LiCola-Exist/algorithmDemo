package string;

/**
 * Created by LiCola on 2018/3/24.
 */
public class StringSort {

  public static void indexSort(String[] a, int index) {
    indexSort(a, index, new String[a.length]);
  }

  static void indexSort(String[] a, int index, String[] aux) {

    int N = a.length;
    int R = 128;//ASCII码 的字符集个数
    int[] count = new int[R + 1];//使用R进制 生成一张表
    //统计频率
    for (int i = 0; i < N; i++) {
      count[a[i].charAt(index) + 1]++;
    }

    //将频率转换为索引
    for (int r = 0; r < R; r++) {
      count[r + 1] += count[r];
    }

    //将元素分类
    for (int i = 0; i < N; i++) {
      aux[count[a[i].charAt(index)]++] = a[i];
    }

    //回写
    for (int i = 0; i < N; i++) {
      a[i] = aux[i];
    }
  }

  /**
   * 字符串排序 低位优先排序算法（LSD）
   */
  public static void sortLSD(String[] a, int wordWidth) {
    int N = a.length;
    String[] aux = new String[N];//辅助空间
    for (int d = wordWidth - 1; d >= 0; d--) {
      indexSort(a, d, aux);
    }

  }
}
