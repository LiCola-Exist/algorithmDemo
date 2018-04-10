package string;

import org.junit.Test;
import util.StdOut;

/**
 * Created by LiCola on 2018/3/24.
 */
public class StringSortLSDTest {


  @Test
  public void sortLSD() {
    String[] source = new String[]{"321", "320", "300","123","323"};
    StringSortLSD.sort(source, 3);
    StdOut.println("低位优先的字符串排序");
    for (String item : source) {
      StdOut.println(item);
    }
  }
}