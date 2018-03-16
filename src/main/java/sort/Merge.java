package sort;

import static sort.Example.less;

/**
 * Created by LiCola on 2018/3/9.
 * 并归排序是一种渐进最优的基于比较的排序算法
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
   * 具体的算法复杂度和方法的调用相关，方法中有两次sort方法递归调用，
   * 方法的调用轨迹类似二叉树（每次都从一个方法长出两个方法），所以时间复杂度O（NlgN）
   *
   * 关于稳定性：
   * 并归排序的，两有序数组合并是稳定性问题的关键，[1,2,3,4,3,5,6]这样的数组，并归的第一次分割发生在中间元素4上，
   * 然后以中间元素4为分割，前后两个数组（中间元素属于前数组），当两个数组合并时，会发生主键相同元素的比较，
   * 只要保证最后结果数组的插入不会发生相对位置交换，相对位置就不会发生改变。所以并归排序是稳定的。
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
    int left = low;//定义左索引
    int right = middle + 1;//定义右索引

    //复制待排序数组到 辅助数组
    for (int k = low; k <= height; k++) {
      aux[k] = a[k];
    }

    //从[low-height]遍历元素
    for (int k = low; k <= height; k++) {
      if (left > middle) {//左半边用尽 只能取右半边元素
        a[k] = aux[right++];
      } else if (right > height) {//右半边用尽 只能取左半边元素
        a[k] = aux[left++];
      } else if (less(aux[left], aux[right])) {//当前索引下 右半边元素小于左半边元素 使用右半边元素 填充
        a[k] = aux[left++];
      } else {////当前索引下 左半边元素小于右半边元素 使用左半边元素 填充
        a[k] = aux[right++];
      }
    }
  }
}
