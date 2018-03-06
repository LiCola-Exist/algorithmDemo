package math;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/6.
 */
public class NarcissisticNumberTest {

  @Test
  public void getNumberWithRange() {
    Integer[] result = new Integer[]{4};
    assertArrayEquals(new Integer[]{153, 370, 371, 407},
        NarcissisticNumber.getNumberWithRange(100,1000).toArray(result));

  }

  @Test
  public void checkNumber() {
    assertEquals(false, NarcissisticNumber.checkNumber(100));
    assertEquals(true, NarcissisticNumber.checkNumber(153));
  }
}