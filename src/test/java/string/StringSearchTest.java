package string;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/12.
 */
public class StringSearchTest {

  @Test
  public void searchViolent() {
    int index = StringSearch.searchViolent("bc", "abc");
    assertEquals(1, index);

    int index1 = StringSearch.searchViolent("ed", "abc");
    assertEquals(-1, index1);
    LLogger.d("search not find index:" + index1);
  }

  @Test
  public void searchBack() {
    int index = StringSearch.searchBack("abc", "ababc");
    assertEquals(2, index);

    int index1 = StringSearch.searchBack("ed", "abc");
    assertEquals(-1, index1);
    LLogger.d("search not find index:" + index1);
  }
}