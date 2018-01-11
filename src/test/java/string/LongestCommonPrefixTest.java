package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/11.
 */
public class LongestCommonPrefixTest {

  @Test
  public void getCommonPrefix() {
    assertEquals("",LongestCommonPrefix.getCommonPrefix(new String[]{}));
    assertEquals("123",LongestCommonPrefix.getCommonPrefix(new String[]{"123","123String","123Integer","123Float"}));
  }
}