package dp;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Test;

/**
 * Created by LiCola on 2018/1/19.
 */
public class ClimbingStairsTest {


  @Test
  public void cale() {
    assertEquals(89, ClimbingStairs.simpleRecursion(10));
    assertEquals(89, ClimbingStairs.memoization(10, new HashMap<>()));
    assertEquals(89, ClimbingStairs.dynamicProgramming(10));
  }

}