package linked;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/11.
 */
public class RemoveDuplicatesFromSortedTest {

  @Test
  public void deleteDuplicates() {
    ListNode head = new ListNode(1);
    ListNode listNodeNext = new ListNode(2);
    ListNode listNodeNext2 = new ListNode(2);
    head.next = listNodeNext;
    listNodeNext.next = listNodeNext2;

    System.out.println("remove before:" + head);

    head = RemoveDuplicatesFromSorted.deleteDuplicates(head);

    System.out.println("remove after:" + head);
  }
}