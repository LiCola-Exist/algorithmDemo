package math;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Test;

/**
 * @author LiCola
 * @date 2019-03-20
 */
public class MonkeysStealPeachesTest {

  @Test
  public void iteration() {
    assertEquals(1023,MonkeysStealPeaches.iteration(1));
  }

  @Test
  public void recursion() {
    assertEquals(1023,MonkeysStealPeaches.recursion(1));
  }
}