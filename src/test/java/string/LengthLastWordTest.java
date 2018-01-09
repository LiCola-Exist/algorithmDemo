package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/9.
 */
public class LengthLastWordTest {

  @Test
  public void length() {
    assertEquals(0,LengthLastWord.length(""));
    assertEquals(5,LengthLastWord.length("hello"));
    assertEquals(5,LengthLastWord.length("hello world"));
    assertEquals(5,LengthLastWord.length("hello world "));
  }
}