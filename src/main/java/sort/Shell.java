package sort;

/**
 * Created by LiCola on 2018/3/2.
 */
public class Shell extends Example {

  /**
   * 希尔排序：基于插入排序的排序算法，对于大规模乱序数组插入排序很慢，因为它只会交换相邻元素，元素只能一点点的移动，
   * 极端情况下，如果主键最小的元素正好在数组末尾，要将它移动正确位置就需要移动N-1次。希尔排序使用交换不相邻元素，
   * 对数组的局部进行排序，最终用插入排序将局部有序的数组排序
   */
  @Override
  public void sort(Comparable[] a) {
    //a[]按升序排序
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = 3 * h + 1;//h的递增 1，4，13，40，121
    }
    while (h >= 1) {
      //将数组变成h有序
      for (int i = h; i < N; i++) {
        //将a[i-h],a[i-2*h],a[i-3*h]之中
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }


}
