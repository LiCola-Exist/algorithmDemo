package math;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import java.math.BigInteger;
import org.junit.Test;

/**
 * @author LiCola
 * @date 2018/11/23
 */
public class BigNumberSumTest {

  @Test
  public void sum() {
    assertEquals("4444", BigNumberSum.sum("123", "4321"));
    assertEquals("1000", BigNumberSum.sum("1", "999"));
    assertEquals("1000", BigNumberSum.sum("0", "1000"));
  }
}