package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/8.
 */
public class RemoveElementTest {

  @Test
  public void removeElement() {
    assertEquals(0,RemoveElement.removeElement(new int[]{},1));
    assertEquals(1,RemoveElement.removeElement(new int[]{1,2,2},2));
  }
}