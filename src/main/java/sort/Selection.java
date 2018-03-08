package sort;

/**
 * Created by LiCola on 2018/3/2.
 */
public class Selection extends Example {

  /**
   * 选择排序：最简单的排序算法，因为它在不断的选择剩余元素之中的最小值
   * 算法描述：
   * 首先，找到数组中最小元素，
   * 其次，将它和数组第一个元素交换（如果第一个元素就是最小元素，那就和自己交换）
   * 此后在剩下元素中继续找第二小的元素，并和第二个元素交换，直至到末尾。
   *
   * 缺点：对已经有序的数组（或主键全部相等的数组）和随机数组排序所用时间一样，都需要一次次的扫描数组
   * 优点：数据移动最小，每次交换都会改变两个数组元素的值，只需要N次交换--交换次数和数组大小成线性（其他算法都是线性对数或平方）
   *
   * 命题A：对长度为N的数组，选择排序需要大约N^2/2次比较和N次交换
   */
  @Override
  public void sort(Comparable[] a) {
    //将数组按升序排序 从小到大
    int N = a.length;
    for (int i = 0; i < N; i++) {
      //将a[i]和a[i+1...N]中最小元素交互
      int min = i;//当前最小元素索引
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
        exch(a, i, min);
      }
    }
  }




}
