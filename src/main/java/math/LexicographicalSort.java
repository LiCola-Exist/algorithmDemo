package math;

import java.util.Arrays;

/**
 * Created by LiCola on 2018/4/9.
 * 全排列生成算法-字典序
 * 问题：给定一个正整数，求出离该整数最近且大于它的重排列数，（重排列数，即把各位上的数重排序，从而得到的新数）
 * 如：
 * 输入：12345，返回：12354
 * 输入：12354，返回：12435
 * 输入：12435，返回：12453
 *
 * 假设对一些固定数量的数组成的整数，全排列生成。怎样的数最大，怎样数最小。
 * 极端情况就是，逆序排列最大，顺序排列最小。
 * 即：1，2，3，4，5这五个数。最大组合：54321，最小组合：12345
 * 由这个思考过程，可以从小到大，如对12345，进行规模递增的逆序处理，如12354，12435，12453，依次就可以得到最大的数54321.
 * 这个就是全排列生成算法的-字典序的思考过程。
 *
 * 再来看输入12354，如何得到最近且大于的重排数。就是在尽可能小的范围内，交换位数顺序。
 * 这个范围怎么确定，取决于当前整数的逆序区域。12354逆序的就是（54）最后两位。
 * （54）已经是当前最大组合，无法仅仅交换最后两位得到比原数的数。这就是必须从倒数第3位开始。
 *
 * 总结交换规则：
 * 1：从后向前查看逆序区域，找到逆序区域的前一位，也就是数字交换的边界位
 * 2：把边界位和逆序中刚刚大于它的数组交换。
 * 3：把原来的逆序区域转为顺序，使得数尽可能的小
 */
public class LexicographicalSort {


  public static int[] findNearestNumber(int[] numbers) {
    int[] result = Arrays.copyOf(numbers, numbers.length);
    //第一步 找边界位
    int index = findTransferPoint(result);

    //边界为0，即整个数组已经逆序无法得到更大的数 返回原数
    if (index == 0) {
      return numbers;
    }

    //第二步
    exchangeHead(result, index);

    //第三步
    reverse(result, index);
    return result;
  }

  private static void reverse(int[] numbers, int index) {
    for (int i = index, j = numbers.length - 1; i < j; j--) {
      int temp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = temp;
    }
  }

  private static void exchangeHead(int[] numbers, int index) {
    int head = numbers[index - 1];
    for (int i = numbers.length - 1; i > 0; i--) {
      if (head < numbers[i]) {
        numbers[index - 1] = numbers[i];
        numbers[i] = head;
        break;
      }
    }
  }

  /**
   * 从后往前，查找逆序区域
   * 找到逆序区域的前一位，即数字交换的边界
   */
  private static int findTransferPoint(int[] numbers) {
    for (int i = numbers.length - 1; i > 0; i--) {
      if (numbers[i] > numbers[i - 1]) {
        return i;
      }
    }
    return 0;
  }
}
