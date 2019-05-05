package sort;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LiCola
 * @date 2019-05-05
 */
public class BubbleTest {

  @Before
  public void setUp() throws Exception {
    LLogger.init();
  }

  @Test
  public void sort() {
    Integer[] sort = {3, 6, 5, 8, 2, 7, 4, 9};
    Bubble.sort(sort);

    assertArrayEquals(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9}, sort);
  }

  @Test
  public void sortOptimize1() {
    Integer[] sort = {3, 6, 5, 8, 2, 7, 4, 9};
    Bubble.sortOptimize1(sort);

    assertArrayEquals(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9}, sort);
  }

  @Test
  public void sortOptimize2() {
    Integer[] sort = {4, 5, 3, 2, 6, 7, 8, 9};
    Bubble.sortOptimize2(sort);

    assertArrayEquals(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9}, sort);
  }

  @Test
  public void sortCocktail() {
    Integer[] sort = {2,3,4,5,1};
    Bubble.sortCocktail(sort);

    assertArrayEquals(new Integer[]{1,2,3,4,5}, sort);
  }
}