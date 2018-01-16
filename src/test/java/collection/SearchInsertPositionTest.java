package collection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/16.
 */
public class SearchInsertPositionTest {

  @Test
  public void searchInsert() {
    assertEquals(2,SearchInsertPosition.searchInsert(new int[]{1,3,5,6},5));
    assertEquals(1,SearchInsertPosition.searchInsert(new int[]{1,3,5,6},2));
    assertEquals(4,SearchInsertPosition.searchInsert(new int[]{1,3,5,6},7));
    assertEquals(0,SearchInsertPosition.searchInsert(new int[]{1,3,5,6},0));
  }
}