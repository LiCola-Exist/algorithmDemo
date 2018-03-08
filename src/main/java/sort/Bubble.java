package sort;

/**
 * Created by LiCola on 2018/3/7.
 */
public class Bubble extends Example {

  @Override
  public void sort(Comparable[] a) {
    int N = a.length;
    for (int i = N - 1; i > 0; i--) {//每次 需要排序的内容长度 原始内容的长度的：N-1，N-2
      for (int j = 0; j < i; j++) {//从子内容的 头到位 依次冒泡
        if (less(a[j + 1], a[j])) {
          exch(a, j + 1, j);
        }
      }
    }
  }
}
