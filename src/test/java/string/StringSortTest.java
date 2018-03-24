package string;

import static org.junit.Assert.*;

import org.junit.Test;
import util.StdOut;

/**
 * Created by LiCola on 2018/3/24.
 */
public class StringSortTest {

  @Test
  public void indexSort() {
    String[] source = new String[]{"8", "8", "3", "4", "1", "2", "2","0"};
    StringSort.indexSort(source, 0);
    StdOut.println("字符串索引计数算法");
    for (String item : source) {
      StdOut.println(item);
    }
  }

  @Test
  public void sortLSD() {
    String[] source = new String[]{"910", "920", "800"};
    StringSort.sortLSD(source, 3);
    StdOut.println("低位优先的字符串排序");
    for (String item : source) {
      StdOut.println(item);
    }
  }
}