package math;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/16.
 */
public class BinarySearchTest {

  @Test
  public void search() {
    int search = BinarySearch.search(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 8);
    assertEquals(7,search);
    LLogger.d("二分查找 search:"+search);
  }
}