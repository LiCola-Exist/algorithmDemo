package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LiCola on 2018/3/21.
 */
public class TreeTraversal {


  /**
   * 深度优先遍历 递归形式
   * 根据根节点相对左右子树的访问顺序，可以分为前/中/后序遍历，然后就可以得到3种结果
   * 这里采用前序遍历
   */
  public static List<TreeNode> depthOrderTraversal(TreeNode<String> root, List<TreeNode> result) {
    if (root == null) {
      return result;
    }
    result.add(root);
    depthOrderTraversal(root.left, result);
    depthOrderTraversal(root.right, result);
    return result;
  }

  /**
   * 深度优先遍历 相当于先序遍历
   * 采用非递归方式
   * 需要栈（后进先出LIFO）辅助
   */
  public static List<TreeNode> depthOrderTraversal(TreeNode<String> root) {
    if (root == null) {
      return Collections.EMPTY_LIST;
    }

    ArrayList<TreeNode> result = new ArrayList<>();
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.poll();
      result.add(node);

      if (node.right != null) {
        stack.push(node.right);
      }

      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return result;
  }


  /**
   * 广度优先遍历 就是一层层的遍历
   * 采用非递归方式
   * 需要队列（先进先出FIFO）辅助
   * 对广度优先遍历而言，没有前中后之分，对一个数只有唯一的结果
   */
  public static List<TreeNode> levelOrderTraversal(TreeNode<String> root) {
    if (root == null) {
      return Collections.EMPTY_LIST;
    }

    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    ArrayList<TreeNode> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      result.add(node);
      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return result;
  }
}
