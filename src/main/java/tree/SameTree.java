package tree;

/**
 * Created by LiCola on 2018/1/23.
 * https://leetcode.com/problems/same-tree/
 * 检查两棵二叉树是否相等
 */
public class SameTree {

  /**
   * 比较两树是否相等，直接深度遍历比对各个节点
   */
  public static boolean isSameTree(TreeNode p1, TreeNode p2) {
    if (p1 == null && p2 == null) {
      return true;
    }

    if (p1 == null || p2 == null) {
      return false;
    }

    if (p1.val == p2.val) {
      return isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }

    return false;
  }
}
