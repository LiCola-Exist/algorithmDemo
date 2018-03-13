package dp;

import java.util.HashMap;

/**
 * Created by LiCola on 2018/1/19.
 * https://leetcode.com/problems/climbing-stairs/description/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * 爬楼梯，一次1步或2步，爬到顶部要多少步
 * 假设已经来到最后一步，有且仅有两种情况，1：从8-10走2步，：2：从9-10走1步，依次类推，缩小问题规模
 * 解题思路：这是最简单的动态规划问题，我们推导出公式
 * F(1)=1
 * F(2)=2
 * F(N)=F(N-1)+F(N-2) (N>=3)
 *
 *
 * 动态规划中有三个重要的概念：
 * 1：最有子结构（F(10)=F(9)+F(8),因此F(9)和F(8)就是F(10)的最优子结构）
 * 2：边界（F(1)=1,F(2)=2，就是问题的边界。否则无法得到有限结果）
 * 3：状态转移公式（F(N)=F(N-1)+F(N-2)，就是状态转移公式）
 *
 * 实现代码是我们的讨论的关键。
 */
public class ClimbingStairs {

  /**
   * 最简单的递归模拟出求值结果，但是这个方法的实现，时间复杂度比较高
   * 求解结果类似一个二叉树的生成过程，每次都以2的倍数递增，树高N-1，节点数近似2^(N-1)
   * 时间复杂度近似O（2^N）
   */
  public static int simpleRecursion(int n) {
    if (n < 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    return simpleRecursion(n - 1) + simpleRecursion(n - 2);
  }

  /**
   * 备忘录算法，解决DP计算过程重复步骤较多的情况，缓存计算结果，避免多次计算。
   * 它的时间复杂度，它的计算过程从1到N有N步，大概就是O(N)时间复杂度，因为没有了重复计算。
   * 空间复杂度主要是缓存的计算结果，除1和2之后都缓存起来，一共缓存N-2个数据，空间复杂度也是O(N)。
   * 都是线性阶。
   */
  public static int memoization(int n, HashMap<Integer, Integer> map) {
    if (n < 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    if (map.containsKey(n)) {
      return map.get(n);
    } else {
      int result = memoization(n - 1, map) + memoization(n - 2, map);
      map.put(n, result);
      return result;
    }
  }

  /**
   * 最后的动态规划代码，时间复杂度主要在迭代，就是O(N)
   * 而空间复杂度优化到了极限，数量固定，空间复杂度为O(1)
   */
  public static int dynamicProgramming(int n) {
    if (n < 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int lastOne = 1;//上次的计算结果
    int lastLastOne = 2;//上上次的计算结果
    int temp = 0;

    for (int i = 3; i <= n; i++) {
      temp = lastOne + lastLastOne;//每次迭代都是上次+上上次的结果和
      lastOne = lastLastOne;//更新上次
      lastLastOne = temp;//更新上上次结果
    }

    return temp;
  }
}
