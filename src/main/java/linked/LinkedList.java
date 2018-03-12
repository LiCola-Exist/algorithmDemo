package linked;

/**
 * Created by LiCola on 2017/12/4.
 * 定义Linked 的相关结构和操作
 */
public class LinkedList {

  protected Node head;
  protected Node current;

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
      return current;
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
    System.out.println("----node print----");
    while (current != null) {
      System.out.println("node:" + current.data);
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
   * 当前待删除节点 更换内容data
   * 并直接使用next.next得到他的下一节点后 完全模仿的构造出待删除节点的一下一个节点
   */
  public void deleteNode(Node node) {
    if (node == null) {
      return;
    }
    node.data = node.next.data;//更换内容 使用下一节点 覆盖内容
    node.next = node.next.next;//更新节点链接 直接指向当前节点的下-下节点
  }

  public static final void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    Node nodeIndex = null;
    for (int i = 0; i < 5; i++) {
      Node itemNode = new Node(i);
      linkedList.add(itemNode);
      if (i == 2) {
        nodeIndex = itemNode;
      }
    }
    linkedList.print();
    System.out.println("delete node:" + nodeIndex);
    linkedList.deleteNode(nodeIndex);
    linkedList.print();

  }
}
