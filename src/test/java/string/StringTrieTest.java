package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/4/10.
 */
public class StringTrieTest {

  @Test
  public void get() {
    StringTrie<Integer> trie=new StringTrie<>();
    trie.put("abc",0);
    trie.put("able",1);
    trie.put("available",2);
    trie.put("clone",3);
    trie.put("double",4);

    LLogger.d("find \"able\" in trie:"+trie.get("able"));
  }
}