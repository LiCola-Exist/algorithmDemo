package stack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author LiCola
 * @date 2018/9/28
 */
public class MinStackTest {

  @Test
  public void push() {
  }

  @Test
  public void pop() {
  }

  @Test
  public void peekMin() {

    MinStack minStack = new MinStack();
    minStack.push(2);
    minStack.push(1);
    minStack.push(3);
    minStack.push(4);

    assertEquals(1, minStack.peekMin());

    assertEquals(4, minStack.pop());
    assertEquals(3, minStack.pop());
    assertEquals(1, minStack.pop());

    assertEquals(2, minStack.peekMin());

  }
}