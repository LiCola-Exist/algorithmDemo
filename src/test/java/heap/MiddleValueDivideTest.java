package heap;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/16.
 */
public class MiddleValueDivideTest {

  @Test
  public void getMiddle() {
    MiddleValueDivide<Integer> middleValueDivide = new MiddleValueDivide<>();
    Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (Integer item :
        integers) {
      middleValueDivide.insert(item);
    }

    LLogger.d("getMiddle:" + middleValueDivide.getMiddle());
  }
}