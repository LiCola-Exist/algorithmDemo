package linked;

import linked.LinkedList.Node;

/**
 * Created by LiCola on 2017/12/4.
 * 使用特殊的方法 巧妙的实现链表功能
 */
public class TraceLinked {

  /**
   * 双指针 处理特殊值 或判断链表有环
   */
  public static class DoublePointerLinkedList extends LinkedList {

    /**
     * 问题：单链表获取倒数第K个节点：
     * 解决思路：采用双指针 差异起点 同距离跨步 使用差异化K步起点双指针计算
     * 快节点先走K步，然后双节点同步，当快节点到尾时，慢节点没有到尾，且刚落在倒数第K位上
     */
    public Node getLastK(int k) {
      Node nodeSlow = head;
      Node nodeFast = head;
      for (int i = 0; i < k; i++) {
        nodeFast = nodeFast.next;
      }

      while (nodeFast != null) {
        nodeFast = nodeFast.next;
        nodeSlow = nodeSlow.next;
      }

      return nodeSlow;
    }

    /**
     * 问题：单链表不知道链表长度情况下，得到链表的中点
     * 解决思路：双指针 同时起步 差异化跨步 使用差异化跨步双指针计算中点
     * 快慢双节点同时以头节点起始，快节点跨2步，慢节点跨1步，相同距离 相同执行时间 速度不同 且速度刚好2倍
     * 快节点到尾 慢节点恰好到中点 当节点为双数时（中点为两个情况） 慢节点落在靠后的点
     */
    public Node getMiddle() {
      Node nodeSlow = head;
      Node nodeFast = head;

      while (nodeFast != null && nodeFast.next != null) {
        nodeFast = nodeFast.next.next;//一次走两步
        nodeSlow = nodeSlow.next;
      }

      return nodeSlow;
    }

    /**
     * 问题：判断单链表是否有环
     * 解决思路：首先有环链表是不能遍历完的 无穷无尽 但是也是因为无法遍历完成 所以两个快慢节点 一定能够在环中遇到。
     * 快慢双节点同时从头节点起步，快节点跨2步，慢节点1步，如果能够发生两者相遇 即存在环。
     */
    public Node hasCircle() {
      Node nodeSlow = head;
      Node nodeFast = head;

      while (nodeFast != null && nodeFast.next != null) {
        nodeFast = nodeFast.next.next;
        nodeSlow = nodeSlow.next;
        if (nodeFast == nodeSlow) {
          return nodeFast;
        }
      }

      return null;
    }

    /**
     * 问题：链表存在环，获取环的长度
     * 解决思路：首先根据方法得知链表有环，并且得到快慢指针相遇节点，该节点肯定存在环中，
     * 从该节点一步步走 肯定能够再次回到该节点 而走的步长就是换的长度。
     */
    public int getCircleLength() {
      Node meetNode = hasCircle();

      int length = 0;
      Node stepNode = meetNode;
      while (stepNode != null) {
        stepNode = stepNode.next;
        length++;
        if (stepNode == meetNode) {
          return length;
        }
      }

      return 0;
    }

    /**
     * 获取环的入口
     * 1：快指针先走环长度
     * 2：快慢指针开始走，当两指针相遇即 快指针走了一圈环 慢指针刚好走到环入口
     */
    public Node getCircleEntry() {
      int circleLength = getCircleLength();//先获取环的长度
      if (circleLength == 0) {
        return null;
      }

      //从头走
      Node nodeFast = head;
      Node nodeSlow = head;

      //快指针先走 环的长度
      for (int i = 0; i < circleLength; i++) {
        nodeFast = nodeFast.next;
      }

      //快慢指针开始 当指针碰撞 即 快指针走了一圈环 而慢指针刚好走到环入口
      while (nodeFast != null && nodeSlow != null) {
        nodeSlow = nodeSlow.next;
        nodeFast = nodeFast.next;
        if (nodeFast == nodeSlow) {
          return nodeSlow;
        }
      }

      return null;

    }
  }

  public static final void main(String[] args) {
    DoublePointerLinkedList linkedList = new DoublePointerLinkedList();
    for (int i = 0; i < 5; i++) {
      linkedList.add(i);
    }
    linkedList.print();
    System.out.println("get 2 last node :" + linkedList.getLastK(2));
    System.out.println("get middle node :" + linkedList.getMiddle());

    System.out.println("this circle test--->");
    DoublePointerLinkedList linkedListCircle = new DoublePointerLinkedList();
    Node nodeLast;
    Node nodeCircleEntry = null;
    int length = 7;
    for (int i = 0; i < length; i++) {
      Node tempNode = linkedListCircle.add(i);

      if (i == 2) {
        nodeCircleEntry = tempNode;
        System.out.println(nodeCircleEntry);
      }

      if (i == (length - 1)) {
        nodeLast = tempNode;
        nodeLast.next = nodeCircleEntry;
      }

    }
    System.out.println("this linked list has circle:" + (linkedListCircle.hasCircle() != null));
    System.out.println("this linked list circle length:" + linkedListCircle.getCircleLength());
    System.out.println("this linked list circle entry:" + linkedListCircle.getCircleEntry().data);
//    linkedListCircle.print();//有环列表 无法遍历完成
  }
}
