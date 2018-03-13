package sort;

import static sort.Example.exch;
import static sort.Example.less;

/**
 * Created by LiCola on 2018/3/7.
 */
public class Bubble  {

  /**
   * 冒泡排序。就是一次次遍历，让当前最大元素依次浮动到元素末端位置。
   *
   * 关于稳定性:
   * 冒泡排序的比较和交换都发生在相邻元素间，通过冒泡主键相同元素会相邻，
   * 只要相邻元素间不发生交换，主键相同元素间就不会发生交换，最后的排序结果，就不会发生相同主键元素相对位置被破坏问题，也就是冒泡排序稳定。
   * @param a
   */
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = N - 1; i >0; i--) {//每次 需要排序的内容长度 原始内容的长度的：N-1，N-2
      for (int j = 0; j < i; j++) {//从子内容的 头到位 依次冒泡
        if (less(a[j + 1], a[j])) {
          exch(a, j + 1, j);
        }
      }
    }
  }

}
