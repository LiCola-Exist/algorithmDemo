package linked;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2017/12/4.
 * 定义Linked 的相关结构和操作
 */
public class LinkedList {

  protected Node head;
  protected Node current;

  public LinkedList() {
  }

  public LinkedList(Node head) {
    this.head = head;
  }

  public Node getHead() {
    return head;
  }

  public Node add(int data) {
    if (head == null) {
      head = new Node(data);
      current = head;
      return head;
    } else {
      current.next = new Node(data);
      current = current.next;
      return current;
    }
  }

  public Node add(Node node) {
    if (head == null) {
      head = node;
      current = node;
      return head;
    } else {
      current.next = node;
      current = current.next;
      return node;
    }
  }

  public void print() {
    printNode(head);
  }

  public static void printNode(Node node) {
    if (node == null) {
      return;
    }

    Node current = node;
    LLogger.d("----node print----");
    while (current != null) {
      LLogger.d("node:" + current.data);
      current = current.next;
    }
  }

  public static class Node {

    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Node{" +
          "data=" + data +
          ", next=" + next +
          '}';
    }
  }

  /**
   * 在O(1)时间复杂度内 删除链表节点
   * 首先因为函数方法中 传入待删除节点 避免遍历过程
   * 采用覆盖方式：
   * 当前待删除节点 更换data内容为next.data
   * 并直接使用next.next得到他的下一节点后 模仿出待删除节点的一下节点
   * 其实就是删除不发生在当前待删除节点，被删除的其实是当前节点的下一节点
   */
  public void delete(Node node) {
    if (node == null) {
      return;
    }

    //面对单链表 是无法在O（1）时间复杂度内 完成末位删除的 只能遍历删除 时间复杂度O（N）
    if (node.next == null) {
      remove(node);
      return;
    }

    node.data = node.next.data;//更换内容 使用下一节点 覆盖内容
    node.next = node.next.next;//更新节点链接 直接指向当前节点的下-下节点
  }

  private void remove(Node node) {
    Node cur = head;
    while (cur != null) {
      Node next = cur.next;
      if (next == node) {
        cur.next = next.next;
      }
      cur = next;
    }
  }


  public static final void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    Node nodeIndex = null;
    for (int i = 0; i < 5; i++) {
      Node itemNode = new Node(i);
      linkedList.add(itemNode);
      if (i == 4) {
        nodeIndex = itemNode;
      }
    }
    linkedList.print();
    LLogger.d("delete node:" + nodeIndex);
    linkedList.delete(nodeIndex);
    linkedList.print();

  }


}
