package linked;


import static linked.LinkedList.printNode;

import com.licola.llogger.LLogger;
import linked.LinkedList.Node;

/**
 * Created by LiCola on 2017/12/19.
 */
public class MergeSortLinked {


  public static final void main(String[] args) {
    LinkedList linkedList1 = new LinkedList();
    linkedList1.add(1);
    linkedList1.add(3);
    linkedList1.add(5);

    linkedList1.print();

    LinkedList linkedList2 = new LinkedList();
    linkedList2.add(2);
    linkedList2.add(4);
    linkedList2.add(6);
    linkedList2.add(7);
    linkedList2.add(8);

    linkedList2.print();

    Node mergerTwoList = merger(linkedList1.getHead(), linkedList2.getHead());
    printNode(mergerTwoList);

    LinkedList linkedListOrder = new LinkedList();
    for (int i = 3; i > 0; i--) {
      linkedListOrder.add(i);
    }
    LLogger.d("待排序单链表");
    printNode(linkedListOrder.getHead());
    Node sort = sort(linkedListOrder.getHead());
    LLogger.d("排序完成");
    printNode(sort);
  }

  public static Node sort(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node middle = getMiddle(head);
    Node half = middle.next;
    middle.next = null;//拆分链表
    return merger(sort(head), sort(half));
  }

  /**
   * 快慢指针 得到 链表中间节点
   */
  private static Node getMiddle(Node node) {
    if (node == null) {
      return null;
    }

    Node fast = node;
    Node slow = node;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 合并两个有序链表
   * 和并归排序中的合并两个有序数组类似
   * 但是因为链表的特点 对两个链表的合并 相比数组合并可以省略辅助空间
   */
  private static Node merger(Node node1, Node node2) {

    //辅助的 head链表头
    Node head = new Node(0);
    Node cur = head;

    //同步遍历 比对大小 因为两者有序 只要挨个比对 插入 就是有序链表
    while (node1 != null && node2 != null) {
      if (node1.data < node2.data) {
        cur.next = node1;
        node1 = node1.next;
      } else {
        cur.next = node2;
        node2 = node2.next;
      }
      cur = cur.next;
    }

    //通过以上遍历 可能会有 list1和list2 长度不一 处理剩余 直接拼接
    cur.next = node1 != null ? node1 : node2;

    return head.next;
  }
}
