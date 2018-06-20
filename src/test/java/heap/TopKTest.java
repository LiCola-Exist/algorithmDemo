package heap;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import java.util.Arrays;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/9.
 */
public class TopKTest {

  @Test
  public void add() {
    int limit = 4;
    TopK<Integer> topK = new TopK<>(limit);
    for (int i = 0; i < 10; i++) {
      topK.add(i);
    }
    LLogger.d("top " + limit + ":" + Arrays.toString(topK.toArray(new Integer[limit])));
  }
}