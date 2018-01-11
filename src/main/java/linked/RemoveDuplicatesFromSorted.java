package linked;

/**
 * Created by LiCola on 2018/1/11.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * 有序且可能存在重复的链表，一次遍历删除全部的重复元素
 */
public class RemoveDuplicatesFromSorted {

  public static ListNode deleteDuplicates(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode curr = head;
    while (curr.next != null) {
      if (curr.next.val == curr.val) {
        //删除操作 删除当前节点的后续 直接使用后续的后续
        curr.next = curr.next.next;
      } else {
        //迭代操作
        curr = curr.next;
      }
    }

    return head;
  }
}
