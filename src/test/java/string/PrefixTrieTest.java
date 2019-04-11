package string;

import static org.junit.Assert.*;

import com.licola.llogger.LLogger;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LiCola
 * @date 2019-04-11
 */
public class PrefixTrieTest {

  @Before
  public void setUp() throws Exception {
    LLogger.init();
  }


  @Test
  public void search() {

    PrefixTrie trie=new PrefixTrie();

    trie.insert("apple");
    assertEquals(true,trie.search("apple"));
    assertEquals(false,trie.search("app"));

  }

  @Test
  public void startsWith() {

    PrefixTrie trie=new PrefixTrie();

    trie.insert("apple");
    assertEquals(true,trie.startsWith("app"));
  }
}