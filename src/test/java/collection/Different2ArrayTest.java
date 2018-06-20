package collection;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/6.
 */
public class Different2ArrayTest {

  @Test
  public void overlaps() {
    Different2Array different2Array = new Different2Array();
    List<String> a = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      a.add(String.valueOf(i));
    }
    List<String> overlaps = different2Array.overlaps(a, Arrays.asList("100", "200"));
    LLogger.d(overlaps);
    assertEquals(2, overlaps.size());
  }
}