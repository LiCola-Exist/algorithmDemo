package math;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;
import util.StdOut;

/**
 * Created by LiCola on 2018/4/9.
 */
public class LexicographicalSortTest {

  @Test
  public void findNearestNumber() {
    assertArrayEquals(new int[]{1, 2, 4, 3, 5},
        LexicographicalSort.findNearestNumber(new int[]{1, 2, 3, 5, 4}));

    int[] nearestNumber = LexicographicalSort.findNearestNumber(new int[]{4, 3, 1, 2});
    StdOut.println(Arrays.toString(nearestNumber));
  }
}