package sort;

import com.licola.llogger.LLogger;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by LiCola on 2018/3/7.
 */
public class ExampleTest {

  @Test
  public void sortInsertion() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Insertion.sort(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortSelection() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Selection.sort(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);

  }

  @Test
  public void sortBubble() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Bubble.sort(characters);

    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortShell() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Shell.sort(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortMerge() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Merge.sort(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);

    LLogger.d("并归的非递归形式");
    Character[] characters1 = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L',
        'E'};
    Example.show(characters1);
    Merge.sortBottomUp(characters1);
    Example.show(characters1);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters1);
  }

  @Test
  public void sortQuick() {
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    Example.show(characters);
    Quick.sort(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);

  }
}