package string;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2017/10/14.
 */
public class StringReverse {

  public static final void main(String[] args) {
    String target = "123";
    LLogger.d("old target:" + target);
    target = reverseBufferApi(target);
    LLogger.d("reverse target:" + target);
    target = reverseRecursive(target);
    LLogger.d("reverse double reverse target:" + target);
  }

  private static String reverseBufferApi(String target) {
    if (target == null || target.length() <= 1) {
      return target;
    }
    //StringBuilder->AbstractStringBuilder->采用遍历翻转（折半遍历）
    return new StringBuilder(target).reverse().toString();
  }

  /**
   * 递归反转
   * 把问题规模缩小，这就得到两个规模的问题
   * 1：长度大于1的情况：String拆分两个，一个头字符和已经反转好字符串，他们的反转就是反向拼接
   * 2：长度等于1的情况：单独的String反转就是他本身。
   */
  private static String reverseRecursive(String target) {
    if (target == null || target.length() <= 1) {
      return target;
    }

    /**
     * 头字符和已经反转好的字符拼接
     */
    return reverseRecursive(target.substring(1)) + target.charAt(0);
  }
}
