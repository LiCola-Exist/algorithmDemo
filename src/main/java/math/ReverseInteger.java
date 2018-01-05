package math;

/**
 * Created by LiCola on 2018/1/4.
 * https://leetcode.com/problems/reverse-integer/description/
 * 求一个整数的逆序整数，当它逆序整数溢出时，就返回0
 */
public class ReverseInteger {

  /**
   * 整数翻转
   * 思路：依次除10递减位数 然后求余得尾数 乘10递增结果位数 累加得结果
   * 但是注意32位的整数溢出 所以需要long64位保存数据 并在最后判断是否溢出
   */
  public static int reverse(int input) {
    long result = 0;//long保存临时结果
    for (; input != 0; input = input / 10) {//从低到高位的循环
      result = result * 10 + input % 10;//先乘10进一位原始数据 然后累加新数
    }
    return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
  }
}
