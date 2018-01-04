package linked;

import linked.LinkedList.Node;

/**
 * Created by LiCola on 2017/10/11.
 */
public class ReverseLinked {


  public static final void main(String[] args) {
    LinkedList linkedList=new LinkedList();
    for (int i = 0; i < 5; i++) {
      System.out.println(linkedList.add(i));
    }
    linkedList.print();
//     reverseTraverse(nodeFirst);
    linkedList.print(reverseRecursive(linkedList.getHead()));
  }

  /**
   * 递归反转链表 递归的含义把问题缩小规模
   * 如 0-1-2 的反转 即 0 - （1-2）即 0 - (1 -（2)) 的反转 而单独的（2）的反转即本身
   * 这样的我们面对的就是 未反转的链表头和被反转的链表头之后的链表 所以 要做的就是两个链表间互换
   * @param currentNode
   * @return
   */
  private static Node reverseRecursive(Node currentNode) {

    //递归的终止条件 当前节点或当前节点后续节点为空 直接返回
    if (currentNode == null || currentNode.next == null) {
      return currentNode;
    }

    Node nextNode=currentNode.next;
    currentNode.next=null;
    Node reverseRest=reverseRecursive(nextNode);//返回已经反转后的链表
    nextNode.next=currentNode;//当前节点被至于它的后续节点
    return reverseRest;//直接返回已经反转后的链表头
  }

  /**
   * 反转链表 遍历形式 基本原理： 新开两个临时节点 从头开始反转 per用于记录当前节点的前一个节点指向 temp保存当前节点的原有下一节点
   */
  private static Node reverseTraverse(Node nodeFirst) {

    Node pre = nodeFirst;//上一节点
    Node cur = nodeFirst.next;//当前节点
    Node temp = null;//临时节点

    while (cur != null) {
      //遍历
      temp = cur.next;//保存当前节点的下一节点 到临时节点 保留原因指针
      cur.next = pre;//修改当前节点指向上一节点
      pre = cur;//上一节点后移为当前节点
      cur = temp;//当前节点 为临时节点
    }
    nodeFirst.next = null;
    return pre;
  }



}
