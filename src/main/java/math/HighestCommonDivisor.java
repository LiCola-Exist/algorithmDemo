package math;

/**
 * Created by LiCola on 2017/12/4.
 * 求最大公约数
 * 辗转相除法:欧几里得算法
 * 定理：两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数 b%(a%b)==0。
 * 根据以上定理，可以把大数转成小数 避免暴力枚举法
 *
 * 更相减损术：两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。
 */
public class HighestCommonDivisor {

  public static final void main(String[] args) {
    int a = 12550;
    int b = 150;
    System.out.println("a:" + a + " b:" + b + " highest common divisor 1:" + divisor1(a, b));
    System.out.println("a:" + a + " b:" + b + " highest common divisor 2:" + divisor2(a, b));
    System.out.println("a:" + a + " b:" + b + " highest common divisor 3:" + divisor3(a, b));
  }

  /**
   * 辗转相除法 复杂度为 O(log(N)) 但是%取模运行性能较差
   * 为什么取模运算性能差 涉及到汇编语言 % 和 & 操作符都直接对应不同的汇编操作 但是&只需要5个CPU周期 而%需要最少26个CPU时钟周期
   * 相关论证，在JDK的HashMap中 关于hash值和hash表的长度取余操作 就是使用&运行替代
   * 但是&操作有限定条件，就是a&(b-1)中 b必须是2的幂 因为这样的b-1时 就变成除了第一位全为1的二进制 这样&操作才有意义 比如 4（100） 3（011）
   */
  public static int divisor1(int a, int b) {
    if (a % b == 0) {
      return b;
    } else {
      return divisor1(b, a % b);
    }
  }

  /**
   * 更相减损术：不使用%取模 性能会好一点 算法性能不稳定 如果是 1000和1 就需要递归999次（减法 进度太小）
   * 最坏情况的下的 复杂度 O(N) 最坏的情况比辗转相除法还低
   */
  public static int divisor2(int a, int b) {
    if (a == b) {
      return a;
    } else if (a < b) {
      return divisor2(b - a, a);
    } else {
      return divisor2(a - b, b);
    }
  }

  public static int divisor3(int a, int b) {
    if (a == b) {
      return b;
    } else if (a < b) {
      return divisor3(b, a);
    } else {
      if (((a & 1) == 0) && (((b & 1) == 0))) {
        return divisor3(a >> 1, b >> 1) << 1;
      } else if ((a & 1) == 0 && (b & 1) != 0) {
        return divisor3(a >> 1, b);
      } else if ((a & 1) != 0 && (b & 1) == 0) {
        return divisor3(a, b >> 1);
      } else {
        return divisor3(b, a - b);
      }
    }
  }
}
