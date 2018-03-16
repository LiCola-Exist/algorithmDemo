package math;

/**
 * Created by LiCola on 2018/3/16.
 */
public class BinarySearch {

  /**
   * 二分查找
   * 时间复杂度O（lgN），因为每次查找过程类似二叉树的构造
   * @param src
   * @param target
   * @return
   */
  public static int search(Comparable[] src, Comparable target) {
    int low = 0;
    int height = src.length - 1;

    while (low <= height) {
      int middle = (low + height) >> 1;
      int result = src[middle].compareTo(target);
      if (result < 0) {
        //中间元素小于查找元素 缩减到右边
        low = middle + 1;
      } else if (result > 0) {
        //中间元素大于查找元素 缩减到左半边
        height = middle - 1;
      } else {
        //查找得到
        return middle;
      }
    }

    return -1;
  }
}
