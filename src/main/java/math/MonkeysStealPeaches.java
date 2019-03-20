package math;

/**
 * 一个猴子来到山里的一棵桃树下， 发现有一堆桃子。第一天它吃掉一个， 然后拿走一半，回到家里，把消息告诉第二个猴子。 第二天第二个猴子也来了，又吃掉一个，然后拿走了一半，
 * 回到家，告诉第三个猴子。第三个猴子也是吃掉一个 ，然后拿走了一半。以此类推，第10天，第10个猴子来到时， 发现还剩下1个桃子。求第一天总共有多少个桃子。 （优先递归程序）
 *
 * @author LiCola
 * @date 2019-03-20
 */
public class MonkeysStealPeaches {


  public static int iteration(int day) {

    int sum = 1;

    while (day < 10) {
      sum = (sum * 2) + 1;
      day = day + 1;
    }

    return sum;
  }

  /**
   * 递归理解 这里递归的返回结束条件就是：第10个猴子来到时，发现还剩下1个桃子 返回条件即：day==10 return 1; 而每次当前的数量条件和下一次的关系：每次先吃掉一个，再拿走一半
   * f(n)=f(n+1)=f(n+1)*2+1 即每一天的情况，都是下一天的两倍（拿走一半）加1（先吃掉一个），从时间维度上把题目逆序理解
   */
  public static int recursion(int day) {

    if (day >= 10) {
      return 1;
    }

    return recursion(day + 1) *2 + 1;
  }
}
