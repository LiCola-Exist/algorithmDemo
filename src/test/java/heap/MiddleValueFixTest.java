package heap;

import org.junit.Test;

/**
 * Created by LiCola on 2018/3/16.
 */
public class MiddleValueFixTest {

  @Test
  public void getMiddle() {
    MiddleValueFix<Integer> middleValueFix = new MiddleValueFix<>();
//    int[] source = new int[]{34, 90, 67, 45, 1, 4, 5, 6, 7, 9, 10};
    int[] source = new int[]{3,2,1,4,8,7,6};
    for (int item :
        source) {
      middleValueFix.add(item);
      LLogger.d("getMiddle:" + middleValueFix.getMiddle());
    }
  }
}