package linked;

import linked.LinkedList.Node;

/**
 * Created by LiCola on 2017/10/11.
 */
public class ReverseLinked {


  public static final void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    for (int i = 0; i < 4; i++) {
      linkedList.add(i);
    }
    linkedList.print();
//     reverseTraverse(nodeFirst);
    LinkedList.printNode(reverseRecursive(linkedList.getHead()));
  }

  /**
   * 递归反转链表 递归的含义把问题缩小规模
   * 如 0-1-2 的翻转调用过程：
   * 1：0-1-2
   * 2：0-(1-2)
   * 3：0-(1-(2))
   * 而单独的（2）的反转即本身，这个就是递归的终止条件
   *
   * 这样的我们面对的就是：未反转的当前节点 和 当前节点next的已经翻转的链表的头（返回值）和尾（当前元素的next值）
   * 整个函数体内，都认为是单个节点+已经翻转的链表 元素结构
   * 所以 要做的就是
   * 1：当前单个节点cur取出后续next节点，并置cur节点后续为空（单个节点的后续肯定是空null）
   * 2：把cur拼接到next之后
   * 3：返回翻转好的链表头
   *
   * 返回值：链表头
   */
  private static Node reverseRecursive(Node curtNode) {

    //递归的终止条件 当前节点的后续节点（或当前节点）为空 直接返回
    //即单节点的链表 翻转就是本身
    if (curtNode == null || curtNode.next == null) {
      return curtNode;
    }

    Node nextNode = curtNode.next;//取出 下一节点
    curtNode.next = null;//单个节点 后续为空null
    Node reverseNode = reverseRecursive(nextNode);//函数调用翻转链表 返回已经反转后的链表头
    nextNode.next = curtNode;//当前节点拼接到后续节点 这是真正的翻转操作
    return reverseNode;//直接返回已经反转后的链表头
  }

  /**
   * 反转链表 遍历形式 基本原理： 新开两个临时节点 从头开始反转 per用于记录当前节点的前一个节点指向 temp保存当前节点的原有下一节点
   */
  private static Node reverseTraverse(Node nodeFirst) {

    Node pre = nodeFirst;//上一节点
    Node cur = nodeFirst.next;//当前节点
    Node temp;//临时节点

    //遍历
    while (cur != null) {
      temp = cur.next;//保存当前节点的下一节点 到临时节点
      cur.next = pre;//修改当前节点指向上一节点
      //当前指针 后移
      pre = cur;//上一节点后移为当前节点
      cur = temp;//当前节点 为临时节点
    }
    nodeFirst.next = null;
    return pre;
  }


}
