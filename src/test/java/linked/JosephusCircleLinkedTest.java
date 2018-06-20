package linked;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import java.util.Arrays;
import java.util.List;
import linked.LinkedList.Node;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/19.
 */
public class JosephusCircleLinkedTest {

  @Test
  public void remove() {
    int size = 5;
    int k = 2;
    LinkedList circle = mackCircle(size);
    int[] removes = JosephusCircleLinked.remove(circle, size, k);
    LLogger.d(Arrays.toString(removes));

    int lastPosition = JosephusCircleLinked.josephus(size, k);
    LLogger.d("josephus last position：" + lastPosition);
  }

  public static LinkedList mackCircle(int size) {

    LinkedList linkedList = new LinkedList();
    Node node = null;
    for (int i = 0; i < size; i++) {
      node = linkedList.add(i + 1);
    }
    node.next = linkedList.getHead();
    return linkedList;
  }
}