package dp;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Test;

/**
 * Created by LiCola on 2018/6/19.
 */
public class MaximumSubarrayTest {

  @Test
  public void maxSubArray() {
    int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSubArray = MaximumSubarray.maxSubArray(a);
    assertEquals(6, maxSubArray);
    LLogger.d(maxSubArray);
  }
}