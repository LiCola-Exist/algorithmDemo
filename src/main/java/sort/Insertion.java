package sort;

/**
 * Created by LiCola on 2018/3/2.
 */
public class Insertion extends Example {

  /**
   * 插入排序：将元素插入到已经有序的数组中
   * 算法描述：
   * 和选择排序一样，当前索引左边的所有元素有序（即使只有一个元素），但是它们最终的位置还不确定，为了给更小的元素腾出空间
   * ，它们可能会被移动，当索引到达数组最右端，排序完成。
   *
   * 特点：和选择排序不同，插入排序所需的时间取决于输入中元素的初始顺序，如果一个很大且其中元素有序（或已经有序）的数组
   * 进行排序，会比对随机数组或逆序数组进行排序快得多。
   *
   * 命题B：对随机排序的长度为N且主键不重复的数组，平均情况下插入排序需要~N^2/4次比较以及~N^2/4，
   * 最坏情况下需要~N^2/2次比较和~N^2/2交换，最好情况下需要N-1次比较和0次交换
   */
  @Override
  public void sort(Comparable[] a) {
    //升序排序
    int N = a.length;
    for (int i = 1; i < N; i++) {
      //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static final void main(String[] args) {
    Insertion selection = new Insertion();
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    selection.show(characters);
    selection.sort(characters);
    selection.show(characters);
  }
}
