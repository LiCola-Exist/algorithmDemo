package sort;

import static sort.Example.less;

/**
 * Created by LiCola on 2018/3/9.
 * 并归排序是一种渐进最优的基于比较的排序算法
 *
 */
public class Merge {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];//开辟辅助空间
    sort(a, 0, a.length - 1);
  }

  /**
   * 自顶向下的并归排序
   * 依靠函数的递归，实现对元素的排序，是分治思想的体现。
   * 具体的算法复杂度和方法的调用相关，方法中有两次sort方法递归调用，方法的调用轨迹类似二叉树（每次都从一个方法长出两个方法），所以时间复杂度O（NlgN）
   */
  public static void sort(Comparable[] a, int low, int height) {
    if (height <= low) {
      return;
    }

    int middle = low + (height - low) / 2;
    sort(a, low, middle);
    sort(a, middle + 1, height);
    merge(a, low, middle, height);
  }

  /**
   * 自底向上的并归排序 和 自顶向下的比较次数和数组的访问次数 相同
   * 自底向上的并归比较适合链表结构，可以实现链表的原地排序
   * @param a
   */
  public static void sortBottomUp(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      //sz为子数组的大小
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        //lo为子数组的索引
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
  }

  /**
   * 原地并归（辅助数组为静态变量 只需要开辟一次内存空间）
   * 用于对一个以middle为界限的两个有序数组[low~middle]，(middle~height]=[middle+1~height]（在同一个数组空间上）的合并
   * 通过合并实现对整个数组段内（low~height）的排序
   */
  public static void merge(Comparable[] a, int low, int middle, int height) {
    int i = low;//定义左索引
    int j = middle + 1;//定义右索引

    //复制待排序数组到 辅助数组
    for (int k = low; k <= height; k++) {
      aux[k] = a[k];
    }

    //从[low-height]遍历元素
    for (int k = low; k <= height; k++) {
      if (i > middle) {//左半边用尽 只能取右半边元素
        a[k] = aux[j++];
      } else if (j > height) {//右半边用尽 只能取左半边元素
        a[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {//当前索引下 右半边元素小于左半边元素 使用右半边元素 填充
        a[k] = aux[i++];
      } else {////当前索引下 左半边元素小于右半边元素 使用左半边元素 填充
        a[k] = aux[j++];
      }
    }
  }
}
