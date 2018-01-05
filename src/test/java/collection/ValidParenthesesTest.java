package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/5.
 */
public class ValidParenthesesTest {

  @Test
  public void isValidStack() {
    assertEquals(true, ValidParentheses.isValidStack("{}"));
    assertEquals(true, ValidParentheses.isValidStack(""));
    assertEquals(true, ValidParentheses.isValidStack(null));
    assertEquals(false, ValidParentheses.isValidStack("]"));
  }
}