package linked;

import linked.LinkedList.Node;

/**
 * Created by LiCola on 2018/3/19.
 */
public class JosephusCircleLinked {


  /**
   * 把问题构成单链表环，采用迭代计数，得到结果
   */
  public static int[] remove(LinkedList linkedList, int size, int time) {

    int index = 0;
    int[] result = new int[size];

    Node cur = linkedList.getHead();
    int times = 0;
    while (true) {

      if (cur == cur.next) {
        //成环单链表的特点 自己的next指向自己
        result[index] = cur.data;
        break;
      }

      if (++times == time) {
        times = 0;//重新计数
        result[index++] = cur.data;//得到剔除位的信息
        linkedList.delete(cur);//剔除节点出环
        continue;
      }
      //迭代链表
      cur = cur.next;
    }

    return result;
  }

  public static int josephus(int n, int k) {
    if (n == 1) {
      return 1;
    } else {
      /*  The position returned by josephus(n - 1, k)
        is adjusted because the recursive call
        josephus(n - 1, k) considers the original
        position k%n + 1 as position 1  */
      return (josephus(n - 1, k) + k - 1) % n + 1;
    }
  }
}
