package linked;

import linked.LinkedList.Node;

/**
 * Created by LiCola on 2017/12/19.
 */
public class MergeLinked {


  public static final void main(String[] args) {
    LinkedList linkedList1 = new LinkedList();
    linkedList1.add(1);
    linkedList1.add(2);
    linkedList1.add(4);

    linkedList1.print();

    LinkedList linkedList2 = new LinkedList();
    linkedList2.add(1);
    linkedList2.add(3);
    linkedList2.add(4);

    linkedList2.print();

    LinkedList mergerTwoList = mergerTwoList(linkedList1, linkedList2);
    mergerTwoList.print();
  }

  /**
   * 合并两个有序链表
   */
  private static LinkedList mergerTwoList(LinkedList list1, LinkedList list2) {
    LinkedList linkedListResult = new LinkedList();

    Node node1 = list1.getHead();
    Node node2 = list2.getHead();

    //list1和list2 同步遍历 比对大小 因为两者有序 只要挨个比对 插入 就是有序链表
    while (node1 != null && node2 != null) {
      if (node1.data < node2.data) {
        linkedListResult.add(node1.data);
        node1 = node1.next;
      } else {
        linkedListResult.add(node2.data);
        node2 = node2.next;
      }
    }

    //通过以上遍历 可能会有 list1和list2 长度不一 处理剩余 直接添加即可
    Node nodeResidue = node1 != null ? node1 : node2;
    while (nodeResidue != null) {
      linkedListResult.add(nodeResidue.data);
      nodeResidue = nodeResidue.next;
    }

    return linkedListResult;
  }
}
