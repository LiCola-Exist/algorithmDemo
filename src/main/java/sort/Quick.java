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

  /**
   * 快排是一种分治的排序算法，将一个数组分割成两个子数组，将两部分独立排序。
   * 快排和并归是互补的，并归排序是先分别两个数组排序，并将有序的子数组并归最后整个数组有序
   * 快排是当两个子数组都有序时，整个数组就是有序的。
   * 快排的关键点是，切分点（partition）的选择。
   */
  private static void sort(Comparable[] a, int low, int height) {
    if (height <= low) {
      return;
    }
    int j = partition(a, low, height);//切分点 该位置已经确定 不用参与后面的排序
    sort(a, low, j - 1);//对左半边 a[low~j-1] 排序
    sort(a, j + 1, height);//对右半边 a[j+1,height] 排序
  }

  /**
   * 切分点的操作
   * 返回j切分点的位置，并保证：
   * 1：对于某个j，a[j]的位置已经排定
   * 2：a[low~j-1]中所有元素都不大于a[j]
   * 3：a[j+1~height]中的所有元素都不小于a[j]
   *
   * 也就是一次切分，总能排定一个元素
   * 这里默认取low作为切分元素。然后分别从左端/右端扫描数组，交换不符合规定的元素，
   *
   * 关于稳定性：
   * 快排的快，一大原因就是比较次数少，不像其他冒泡，插入元素的比较和移动只发生在相邻元素间。
   * 快排依靠切分点，能够对整体元素有一个大概的整理（切分点左小右大），也就是主键相同元素不能直接发生比较，
   * 切分点的交换，就可能发生主键相同元素的相对位置交换。如[5,3,4,3,8,9]，一次切分点交换，就会让第二个3和5交换，
   * 主键相同元素间的相对位置被破坏，不稳定。
   */
  private static int partition(Comparable[] a, int low, int height) {
    int left = low;//左指针
    int right = height + 1;//右指针

    Comparable v = a[low];
    while (true) {
      while (less(a[++left], v)) {//左指针 向右扫描
        if (left == height) {//左指针的临界点
          break;
        }
      }
      while (less(v, a[--right])) {//右指针 向左扫描
        if (right == low) {//右指针的临界点
          break;
        }
      }
      if (left >= right) {//两指针碰撞 退出循环
        break;
      }
      exch(a, left, right);
    }
    //交换
    exch(a, low, right);
    return right;
  }
}
