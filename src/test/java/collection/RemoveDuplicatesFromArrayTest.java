package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/6.
 */
public class RemoveDuplicatesFromArrayTest {

  @Test
  public void removeDuplicates() {
    assertEquals(0, RemoveDuplicatesFromArray.removeDuplicates(new int[]{}));
    assertEquals(1, RemoveDuplicatesFromArray.removeDuplicates(new int[]{1, 1}));
    assertEquals(2, RemoveDuplicatesFromArray.removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(3, RemoveDuplicatesFromArray.removeDuplicates(new int[]{1, 2, 3}));
    assertEquals(5, RemoveDuplicatesFromArray.removeDuplicates(new int[]{1, 2, 2, 3, 3, 4, 5}));
  }
}