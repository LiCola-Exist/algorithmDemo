package math;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Created by LiCola on 2018/1/15.
 */
public class PascalsTriangleTest {

  @Test
  public void generate() {
    assertEquals(Collections.emptyList(), PascalsTriangle.generate(0));

    List<List<Integer>> lists = PascalsTriangle.generate(5);
    for (List<Integer> subList : lists) {
      LLogger.d(subList);
    }

    LLogger.d(PascalsTriangle.getRow(3));
  }
}