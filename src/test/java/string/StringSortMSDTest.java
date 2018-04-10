package string;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;
import util.StdIn;
import util.StdOut;

/**
 * Created by LiCola on 2018/4/9.
 */
public class StringSortMSDTest {

  @Test
  public void sort() {
    String[] input = new String[]{
        "she",
        "sells",
        "seashells",
        "by",
        "the",
        "seashore",
        "then",
        "shells",
        "she",
        "sells",
        "are",
        "available",
        "availability",
        "surely",
        "seashells"};
    StringSortMSD.sort(input);
    StdOut.println("高位优先字符串排序");
    for (String item :
        input) {
      StdOut.println(item);
    }

  }
}