package sort;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by LiCola on 2018/3/7.
 */
public class ExampleTest {

  @Test
  public void sortInsertion() {
    Insertion insertion = new Insertion();
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    insertion.show(characters);
    insertion.sort(characters);
    insertion.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortSelection() {
    Selection selection = new Selection();
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    selection.show(characters);
    selection.sort(characters);
    selection.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortBubble() {
    Bubble bubble = new Bubble();
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    bubble.show(characters);
    bubble.sort(characters);
    bubble.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }

  @Test
  public void sortShell() {
    Shell shell = new Shell();
    Character[] characters = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    shell.show(characters);
    shell.sort(characters);
    shell.show(characters);
    assertArrayEquals(new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'},
        characters);
  }
}