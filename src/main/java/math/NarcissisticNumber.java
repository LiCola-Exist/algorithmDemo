package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2018/3/6.
 * 水仙花数（超完全数字不变数、自恋数、自幂数）：描述一个N位非负整数，其各位数字的N次方和等于该数本身
 */
public class NarcissisticNumber {


  /**
   * 返回某个数的 10进制位数
   */
  static int countDigit(int n) {
    if (n == 0) {
      return 0;
    }

    return 1 + countDigit(n / 10);
  }

  /**
   * 判断某个数 是否为水仙花数
   * 根据水仙花数的定义，判断条件是否满足
   */
  public static boolean checkNumber(int n) {
    int l = countDigit(n);//计算该数的10进制位数
    int dup = n;
    int sum = 0;

    //10进制 位数从低到高 n次幂累加
    while (dup > 0) {
      sum += Math.pow(dup % 10, l);
      dup /= 10;
    }

    return n == sum;
  }

  /**
   * 求范围内的水仙花数
   * 暴露枚举
   */
  public static List<Integer> getNumberWithRange(int min, int max) {
    List<Integer> result = new ArrayList<>();

    for (int i = min; i < max; i++) {
      if (checkNumber(i)) {
        result.add(i);
      }
    }
    return result;
  }
}
