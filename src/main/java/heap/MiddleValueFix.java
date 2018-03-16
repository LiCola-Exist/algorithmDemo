package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by LiCola on 2018/3/16.
 * 从数量不定的无序数据流中，得到中值
 * 这里认为的中值是
 * 总数为奇数的中间元素值（只有一个），偶数的（两个值取一）某个值
 */
public class MiddleValueFix<E extends Comparable<E>> {

  private PriorityQueue<E> mixHeap;//最小堆 根元素（子元素都比根元素大）>=m 大于等于middle的元素
  private PriorityQueue<E> maxHead;//最大堆 根元素（子元素都比根元素小）<=m 小于等于middle的元素

  private E middle;//当前中值

  public MiddleValueFix() {
    mixHeap = new PriorityQueue<>();
    maxHead = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void add(E e) {
    if (middle == null) {
      //第一个元素 直接添加
      middle = e;
      return;
    }

    if (e.compareTo(middle) <= 0) {
      //小于等于中值 加入最大堆
      maxHead.add(e);
    } else {
      //大于中值 加入最小堆
      mixHeap.add(e);
    }

    if (mixHeap.size() - maxHead.size() >= 2) {
      //最小堆元素个数多 即大于中值的数多
      //将middle加入到最大堆 然后将最小堆中的根移除并赋值给 middle
      maxHead.add(middle);
      middle=mixHeap.poll();
    }else if (maxHead.size()-mixHeap.size()>=2){
      mixHeap.add(middle);
      middle=maxHead.poll();
    }
  }

  public E getMiddle() {
    return middle;
  }
}
