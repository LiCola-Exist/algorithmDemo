package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/6.
 */
public class RemoveDuplicatesTest {

  @Test
  public void removeDuplicates() {
    assertEquals(0, RemoveDuplicates.removeDuplicates(new int[]{}));
    assertEquals(1, RemoveDuplicates.removeDuplicates(new int[]{1, 1}));
    assertEquals(2, RemoveDuplicates.removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(3, RemoveDuplicates.removeDuplicates(new int[]{1, 2, 3}));
    assertEquals(5, RemoveDuplicates.removeDuplicates(new int[]{1, 2, 2, 3, 3, 4, 5}));
  }
}