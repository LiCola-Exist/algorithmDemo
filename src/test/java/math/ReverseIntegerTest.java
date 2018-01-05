package math;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/4.
 */
public class ReverseIntegerTest {

  @Test
  public void reverse() {
    assertEquals(321, ReverseInteger.reverse(123));
    assertEquals(-321, ReverseInteger.reverse(-123));
    assertEquals(21, ReverseInteger.reverse(120));
    assertEquals(0, ReverseInteger.reverse(Integer.MAX_VALUE));

  }
}