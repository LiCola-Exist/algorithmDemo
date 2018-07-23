package queue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author LiCola
 * @date 2018/7/23
 */
public class TwoStackQueueTest {


  @Test
  public void poll() {
    TwoStackQueue<String> stackQueue=new TwoStackQueue<>();
    stackQueue.add("1");
    stackQueue.add("2");
    stackQueue.add("3");
    assertEquals("1",stackQueue.poll());

    stackQueue.add("4");
    stackQueue.add("5");

    assertEquals("2",stackQueue.poll());
    assertEquals("3",stackQueue.poll());
    assertEquals("4",stackQueue.poll());
    assertEquals("5",stackQueue.poll());


  }

  @Test
  public void peek() {
  }
}