package string;

/**
 * Created by LiCola on 2017/10/14.
 */
public class StringReverse {

  public static final void main(String[] args) {
    String target = "123";
    System.out.println("old target:" + target);
    target = reverseBufferApi(target);
    System.out.println("reverse target:" + target);
    target = reverseRecursive(target);
    System.out.println("reverse double reverse target:" + target);
  }

  private static String reverseBufferApi(String target) {
    if (target == null || target.length() <= 1) {
      return target;
    }
    return new StringBuilder(target).reverse().toString();
  }

  /**
   * 递归反转
   * 把问题规模缩小，这就得到两个规模的问题
   * 1：长度大于1的情况：String拆分两个，一个头和已经反转好的尾部，他们的反转就是反向拼接
   * 2：长度等于1的情况：单独的String反转就是他本身。
   *
   * @param target
   * @return
   */
  private static String reverseRecursive(String target) {
    if (target == null || target.length() <= 1) {
      return target;
    }

    return reverseRecursive(target.substring(1)) + target.charAt(0);
  }
}
