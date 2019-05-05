package sort;

import static sort.Example.exch;
import static sort.Example.less;

/**
 * Created by LiCola on 2018/3/7.
 */
public class Bubble {

  /**
   * 冒泡排序。就是一次次遍历，让当前最大元素依次浮动到元素末端位置。
   *
   * 关于稳定性: 冒泡排序的比较和交换都发生在相邻元素间，通过冒泡主键相同元素会相邻， 只要相邻元素间不发生交换，主键相同元素间就不会发生交换，
   * 最后的排序结果，就不会发生相同主键元素相对位置被破坏问题，也就是冒泡排序稳定。
   */
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = N - 1; i > 0; i--) {//每次 需要排序的内容长度 原始内容的长度的：N-1，N-2
      for (int j = 0; j < i; j++) {//从子内容的 头到位 依次冒泡
        if (less(a[j + 1], a[j])) {
          exch(a, j + 1, j);
        }
      }
    }
  }

  /**
   * 优化版本1，维度是对外层遍历的优化，加入标志位省略多余外层遍历 因为其实每次的外层遍历的内部遍历都是从头到尾，走过无序数组，如果内部一次内层循环已经有序，
   * 后面的遍历就是无意义的，可以通过标志位标识一次有序的遍历，然后跳出循环完成排序 极端情况下就是，一次外层for循环知道有序，然后就返回
   */
  public static void sortOptimize1(Comparable[] a) {

    int N = a.length;
    boolean isOrder;
    for (int i = N - 1; i > 0; i--) {
      isOrder = true;//每次开始大循环 都可以假设有序
      for (int j = 0; j < i; j++) {
        if (less(a[j + 1], a[j])) {
          exch(a, j + 1, j);
          //出现交互 即这次循环有无序元素
          isOrder = false;
        }
      }

      //理想情况下 若干次遍历 就可以完整的 有序 然后直接返回
      if (isOrder) {
        return;
      }
    }
  }

  /**
   * 优化版本2，维度是对内层遍历的长度优化。 如果一次外层循环，内部循环会走过所有元素，出现的交换点之后都是有序的，如果这个交换点出现在很前面的位置，优化就是很客观的，
   * 后续的元素不再需要比较，
   */
  public static void sortOptimize2(Comparable[] a) {

    int N = a.length;
    boolean isOrder;
    int lastExchIndex = 0;
    int unorderBorder = N - 1;
    for (int i = N - 1; i > 0; i--) {
      isOrder = true;//每次开始大循环 都可以假设有序
      for (int j = 0; j < unorderBorder; j++) {
        if (less(a[j + 1], a[j])) {
          exch(a, j + 1, j);
          //出现交互 即这次循环有无序元素
          isOrder = false;
          lastExchIndex = j;
        }
      }
      unorderBorder = lastExchIndex;
      //理想情况下 若干次遍历 就可以完整的 有序 然后直接返回
      if (isOrder) {
        return;
      }
    }
  }

  /**
   * 鸡尾酒循环，对冒泡的特殊优化，排序区间来回摇摆，方向左右来回循环， 特殊的针对，2，3，4，5，1这样的排序。避免普通的冒泡内次都从左到右。
   * 扩展一次外层循环，先左最大到尾，在右最小到头，然后就可以标志位优化判定有序，结束循环。
   */
  public static void sortCocktail(Comparable[] a) {
    int i = 0;
    int left = 0;
    int right = a.length - 1;
    boolean isOrder;
    while (left < right) {
      isOrder = true;
      for (i = left; i < right; i++) {
        if (less(a[i + 1], a[i])) {
          exch(a, i + 1, i);
          isOrder = false;
        }
      }
      if (isOrder) {
        return;
      }

      right--;
      isOrder = true;
      for (i = right; i > left; i--) {
        if (less(a[i], a[i - 1])) {
          exch(a, i - 1, i);
          isOrder = false;
        }
      }
      if (isOrder) {
        return;
      }

      left++;
    }
  }

}
