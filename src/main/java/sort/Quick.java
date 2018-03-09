package sort;

import static sort.Example.exch;
import static sort.Example.less;

import java.util.Collections;

/**
 * Created by LiCola on 2018/3/9.
 */
public class Quick {

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int low, int height) {
    if (height <= low) {
      return;
    }
    int j = partition(a, low, height);//切分点
//    System.out.println("partition:"+j);
    sort(a, low, j - 1);//对左半边 a[low~j-1] 排序
    sort(a, j + 1, height);//对右半边 a[j+1,height] 排序

  }

  private static int partition(Comparable[] a, int low, int height) {
    int i = low;//左指针
    int j = height + 1;//右指针

    Comparable v = a[low];
    while (true) {
      while (less(a[++i], v)) {
        if (i == height) {
          break;
        }
      }
      while (less(v, a[--j])) {
        if (j == low) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, low, j);
    return j;
  }
}
