package string;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Test;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class StringListTest {

  @Test
  public void reverse() {
    String input = "Hello World";
    String result = StringList.reverse(input);
    LLogger.d(result);
  }
}