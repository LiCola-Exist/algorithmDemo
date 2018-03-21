package tree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/23.
 */
public class SameTreeTest {

  @Test
  public void isSame() {
    TreeNode<Integer> root1= TreeNode.makeTree(0,1,2);

    TreeNode<Integer> root2 = TreeNode.makeTree(10,20,30);
    assertEquals(false, SameTree.isSameTree(root1, root2));
    assertEquals(true, SameTree.isSameTree(root1, root1));
    assertEquals(false, SameTree.isSameTree(root1, null));

  }
}