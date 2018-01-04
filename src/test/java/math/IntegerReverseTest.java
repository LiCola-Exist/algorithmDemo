package math;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/4.
 */
public class IntegerReverseTest {

  @Test
  public void reverse() {
    assertEquals(321, IntegerReverse.reverse(123));
    assertEquals(-321, IntegerReverse.reverse(-123));
    assertEquals(21, IntegerReverse.reverse(120));
    assertEquals(0, IntegerReverse.reverse(Integer.MAX_VALUE));

  }
}