package tree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/1/23.
 */
public class SameTreeTest {

  @Test
  public void isSame() {
    TreeNode root1 = new TreeNode(0);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(2);

    TreeNode root2 = new TreeNode(0);
    root1.left = new TreeNode(20);
    root1.right = new TreeNode(10);
    assertEquals(false, SameTree.isSameTree(root1, root2));
    assertEquals(true, SameTree.isSameTree(root1, root1));
    assertEquals(false, SameTree.isSameTree(root1, null));

  }
}