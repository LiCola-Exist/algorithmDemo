package collection;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/10.
 */
public class BitMapDuplicatesTest {

  @Test
  public void duplicate() {
    List<Integer> duplicate = BitMapDuplicates
        .duplicate(new int[]{1, 2, 4, 8, 16, 30, 32, 100,1000000000}, new int[]{2, 30, 32, 100, 200});
    System.out.println(Arrays.toString(duplicate.toArray()));
  }
}