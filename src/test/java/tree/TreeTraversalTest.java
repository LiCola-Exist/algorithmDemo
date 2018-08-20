package tree;

import com.licola.llogger.LLogger;
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
    LLogger.d("深度优先遍历 递归实现:");
    for (TreeNode item :
        result) {
      LLogger.d(item.val);
    }

    List<TreeNode> treeNodes = TreeTraversal.depthOrderTraversal(root);
    LLogger.d("深度优先遍历 迭代 栈实现:");
    for (TreeNode item :
        treeNodes) {
      LLogger.d(item.val);
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
    LLogger.d("广度优先遍历 迭代 队列实现:");
    for (TreeNode item :
        result) {
      LLogger.d(item.val);
    }
  }
}