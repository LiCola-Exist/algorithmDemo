package sort;

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
//    Merge.sortBottomUp(characters);
    Example.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }
}