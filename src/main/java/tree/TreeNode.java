package tree;

/**
 * Created by LiCola on 2018/1/23.
 */
public class TreeNode<T> {

  public T val;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(T val) {
    this.val = val;
  }

  public static <T> TreeNode<T> makeTree(T... values) {

    if (values.length <= 0) {
      throw new IllegalArgumentException("构造树参数错误");
    }

    TreeNode<T> root = new TreeNode<>(values[0]);
    root.left = new TreeNode<>(values[1]);
    root.right = new TreeNode<>(values[2]);
    root.left.left=new TreeNode<>(values[3]);
    root.left.right=new TreeNode<>(values[4]);

    return root;
  }
}
