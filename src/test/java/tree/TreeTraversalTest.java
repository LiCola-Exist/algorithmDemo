package tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/21.
 */
public class TreeTraversalTest {

  @Test
  public void depthOrderTraversal() {
    /**
     * 树的结构
     *      root
     *    A      B
     *  C  D
     *
     *  使用类似堆的方式构造树
     */
    TreeNode<String> root = TreeNode.makeTree("root", "A", "B", "C", "D");
    ArrayList<TreeNode> result = new ArrayList<>();
    TreeTraversal.depthOrderTraversal(root, result);
    System.out.println("深度优先遍历 递归实现:");
    for (TreeNode item :
        result) {
      System.out.println(item.val);
    }

    List<TreeNode> treeNodes = TreeTraversal.depthOrderTraversal(root);
    System.out.println("深度优先遍历 迭代 栈实现:");
    for (TreeNode item :
        treeNodes) {
      System.out.println(item.val);
    }

  }

  @Test
  public void levelOrderTraversal() {
    /**
     * 树的结构
     *      root
     *    A      B
     *  C  D
     *
     *  使用类似堆的方式构造树
     */
    TreeNode<String> root = TreeNode.makeTree("root", "A", "B", "C", "D");
    List<TreeNode> result = TreeTraversal.levelOrderTraversal(root);
    System.out.println("广度优先遍历 迭代 队列实现:");
    for (TreeNode item :
        result) {
      System.out.println(item.val);
    }
  }
}