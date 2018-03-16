package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by LiCola on 2018/3/16.
 * 源源不断的数据流中取出中位数。
 * 这里的中位数是：以数据总数量的情况分为
 * 1：奇数总数，中值为确定
 * 2：偶数总数，中值为中间两个元素平均值
 *
 * 用堆来处理中值问题的思想：
 * 首先我们只需要关注中间的一个或两个值，全局具体顺序不考虑。而关注的值就可以放在堆的根节点上，方便访问（O（1）非常快）
 * 把数据平分到 两个堆中，最大堆和最小堆。并建立堆之间的关系
 * 堆的数据特性就是，根节点是所有数据中的最大（或最小值）。
 * 当最大堆的根（最大值）比 最小堆的根（最小值）还要小的时候，两个堆之间就建立起了联系，根的元素关系之间连续。
 * 然后只要保证两个堆的数量，相对平均，那么中值自然就在根。
 */
public class MiddleValueDivide<E extends Number & Comparable<E>> {

  private int sum = 0;//总数计数
  private PriorityQueue<E> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//最大堆 维护左半边元素
  private PriorityQueue<E> minHeap = new PriorityQueue<>();//最小堆 维护右半边元素

  public void insert(E e) {
    sum++;//总数+1
    if (sum % 2 == 0) {
      //偶数 插入到最小堆（右半边）
      maxHeap.add(e);
      E tmp = maxHeap.poll();
      minHeap.add(tmp);
    } else {
      //奇数 最后导致最大堆的数量 比最小堆多1
      minHeap.add(e);
      E tmp = minHeap.poll();//两行代码 调整出最小堆（比较大的部分数据）的最小值
      maxHeap.add(tmp);//使用最小堆的淘汰的最小值 作为最大堆的最大值 让大小堆的根连续
    }
  }

  public double getMiddle() {
    if (sum % 2 == 0) {
      return (maxHeap.peek().doubleValue() + minHeap.peek().doubleValue()) / 2;
    } else {
      return maxHeap.peek().doubleValue();
    }
  }
}
