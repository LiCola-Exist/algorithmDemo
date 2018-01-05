package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/5.
 */
public class VaildParenthesesTest {

  @Test
  public void isValidStack() {
    assertEquals(true,VaildParentheses.isValidStack("{}"));
    assertEquals(true,VaildParentheses.isValidStack(""));
    assertEquals(true,VaildParentheses.isValidStack(null));
    assertEquals(false,VaildParentheses.isValidStack("]"));
  }
}